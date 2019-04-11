package com.github.xenteros.mapper;


import com.github.xenteros.dto.BookDto;
import com.github.xenteros.model.Book;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructBookMapper {

    BookDto toBookDto(Book book);

    Book toBook(BookDto bookDto);

    List<BookDto> toBookDto(Collection<Book> books);

}
