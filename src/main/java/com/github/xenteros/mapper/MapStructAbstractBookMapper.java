package com.github.xenteros.mapper;

import com.github.xenteros.dto.BookDto;
import com.github.xenteros.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.List;

import static org.mapstruct.ReportingPolicy.ERROR;
import static org.mapstruct.ReportingPolicy.WARN;

@Mapper(componentModel = "spring", unmappedTargetPolicy = WARN)
public abstract class MapStructAbstractBookMapper {

    public Book toBook(BookDto bookDto) {
        if (bookDto == null) {
            return null;
        }

        Book book = new Book();

        book.setTitle(bookDto.getTitle());
        book.setId(-1L);

        return book;
    }

    public abstract BookDto toBookDto(Book book);

    public abstract List<BookDto> toBookDto(Collection<Book> books);

}
