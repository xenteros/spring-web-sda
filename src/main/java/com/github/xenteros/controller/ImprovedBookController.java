package com.github.xenteros.controller;


import com.github.xenteros.dto.BookDto;
import com.github.xenteros.mapper.BookMapper;
import com.github.xenteros.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v2/books")
public class ImprovedBookController {

    private BookMapper bookMapper;
    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    public ImprovedBookController(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookMapper.toBookDto(books);
    }

    @GetMapping("/{id}")
    public BookDto findBookById(@PathVariable Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .map(bookMapper::toBookDto)
                .orElseThrow(RuntimeException::new);
    }

    @DeleteMapping("/{id}")
    public void removeBookById(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto) {
        Book book = new Book(nextId++, bookDto.getAuthor(), bookDto.getTitle());
        books.add(book);
        return bookMapper.toBookDto(book);
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id,
                              BookDto bookDto) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .map(book -> updateBook(book, bookDto.getTitle(), bookDto.getAuthor()))
                .map(bookMapper::toBookDto)
                .orElseThrow(RuntimeException::new);
    }

    private Book updateBook(Book book, String newTitle, String newAuthor) {
        book.setAuthor(newAuthor);
        book.setTitle(newTitle);
        return book;
    }
}
