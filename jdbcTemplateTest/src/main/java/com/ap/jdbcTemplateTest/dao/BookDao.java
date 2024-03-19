package com.ap.jdbcTemplateTest.dao;

import com.ap.jdbcTemplateTest.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String isbn);
}
