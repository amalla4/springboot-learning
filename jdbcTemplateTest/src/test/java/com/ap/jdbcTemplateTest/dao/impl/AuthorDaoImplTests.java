package com.ap.jdbcTemplateTest.dao.impl;

import com.ap.jdbcTemplateTest.TestDataUtil;
import com.ap.jdbcTemplateTest.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private AuthorDaoImpl underTest;

//====================== CREATE TESTS ===========================//
    @Test
    public void testThatCreateAuthorGeneratesCorrectSql(){
        Author author = TestDataUtil.createTestAuthorA();
        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L), eq("AP Malla"), eq(27)
        );
    }

//====================== READ TESTS ===========================//
    @Test
    public void testThatFindsOneGeneratesCorrectSql(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L)
        );
    }

    @Test
    public void testThatFindManyGeneratesCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any()
        );
    }

//====================== UPDATE TESTS ===========================//
    @Test
    public void testThatUpdateGeneratesCorrectSql(){
        Author author = TestDataUtil.createTestAuthorA();
        underTest.update(3L, author);

        verify(jdbcTemplate).update(
                "UPDATE authors SET id=?, name=?, age=? WHERE id=?",
                1L, "AP Malla", 27, 3L
        );
    }

//====================== DELETE TESTS ===========================//

}
