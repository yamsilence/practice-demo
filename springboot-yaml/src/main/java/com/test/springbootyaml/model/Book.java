package com.test.springbootyaml.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@ConfigurationProperties(prefix = "book")
public class Book {
    private String name;
    private List<String> tags;

    private List<Author> authors;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", tags=" + tags +
                ", authors=" + authors +
                '}';
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
