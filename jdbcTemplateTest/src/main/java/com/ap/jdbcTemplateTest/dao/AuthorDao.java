package com.ap.jdbcTemplateTest.dao;

import com.ap.jdbcTemplateTest.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);
    //using Optional for more type safety?
    //if id returns author - wrapped in Optional
    // if id does not have author - empty wrapped in Optional
    Optional<Author> findOne(long l);

    List<Author> find();

    void update(Author author);
}
