package com.ap.jdbcTemplateTest.dao;

import com.ap.jdbcTemplateTest.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);
    //Optional<> for type safety: if id returns author-wrapped in Optional, else-empty wrapped in Optional
    Optional<Author> findOne(long l);
    List<Author> find();
    void update(long id, Author author);
    void delete(long id);
}
