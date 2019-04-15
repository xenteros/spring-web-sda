package com.github.xenteros.mapper;

import com.github.xenteros.dto.BookDto;
import com.github.xenteros.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.List;

import static org.mapstruct.ReportingPolicy.ERROR;
import static org.mapstruct.ReportingPolicy.WARN;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ERROR, uses = {AuthorMapper.class})
public interface MapStructBookMapper {

    @Mappings({
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "author", target = "authorName")
//            @Mapping(source = "author", target = "authorName")
//            @Mapping(target = "authorName", ignore = true)
//            @Mapping(target = "authorName",
//                    expression = "java(book.getAuthor().toUpperCase())")
    })
    BookDto toBookDto(Book book);

    List<BookDto> toBookDto(Collection<Book> books);

}
