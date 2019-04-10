package com.github.xenteros.mapper;

import com.github.xenteros.dto.BookDto;
import com.github.xenteros.model.Book;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Component
public class BookMapper {

    public BookDto toBookDto(Book book) {
        BookDto result = new BookDto();
        result.setAuthor(book.getAuthor());
        result.setTitle(book.getTitle());
        return result;
    }

    public Book toBook(BookDto bookDto) {
        Book result = new Book();
        result.setTitle(bookDto.getTitle());
        result.setAuthor(bookDto.getAuthor());
        return result;
    }

    public List<BookDto> toBookDto(Collection<Book> books) {
        return books.stream()
                .map(this::toBookDto)
                .collect(toList());
    }
}
