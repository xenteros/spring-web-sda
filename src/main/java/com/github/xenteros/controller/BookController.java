package com.github.xenteros.controller;


import com.github.xenteros.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
class BookController {

    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @DeleteMapping("/{id}")
    public void removeBookById(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    @PostMapping
    public Book createBook(@RequestParam String title, @RequestParam String author) {
        Book book = new Book(nextId++, null, title);
        books.add(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestParam String newAuthor,
                           @RequestParam String newTitle) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .map(book -> updateBook(book, newTitle, newAuthor))
                .orElseThrow(RuntimeException::new);
    }

    private Book updateBook(Book book, String newTitle, String newAuthor) {
//        book.setAuthor(newAuthor);
        book.setTitle(newTitle);
        return book;
    }
}
