package com.github.xenteros.mapper;

import com.github.xenteros.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AuthorMapper {

    public String toString(Author author) {
        return author.getFirstName() + " " + author.getLastName().toUpperCase();
    }
}
