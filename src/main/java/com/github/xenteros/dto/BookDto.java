package com.github.xenteros.dto;

import com.github.xenteros.validation.StartsWithCapitalLetter;
import org.hibernate.validator.constraints.NotBlank;

public class BookDto {


    @NotBlank(message = "Title must not be blank")
    private String title;

    @NotBlank(message = "Author must not be blank")
    @StartsWithCapitalLetter
    private String authorName;

    public BookDto() {
    }
    public BookDto(String title, String authorName) {
        this.title = title;
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
