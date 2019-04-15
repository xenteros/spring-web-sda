package com.github.xenteros.controller;

import com.github.xenteros.dto.BookDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
class ViewController {

    private List<BookDto> bookDtos;

    public ViewController() {
        bookDtos = new ArrayList<>();
        bookDtos.add(new BookDto("Pan Tadeusz", "Adam Mickiewicz"));
        bookDtos.add(new BookDto("Balladyna", "Juliusz Słowacki"));
        bookDtos.add(new BookDto("Lalka", "Bolesław Prus"));
        bookDtos.add(new BookDto("Zmesta Fredry", "Author Unknown"));
    }

    @GetMapping("/hello-world")
    public String helloWorld(Model model) {
        model.addAttribute("greeting", "Witaj Tymianku!");
        return "hello-world";
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookDtos);
        return "books";
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "greeting";
    }


}
