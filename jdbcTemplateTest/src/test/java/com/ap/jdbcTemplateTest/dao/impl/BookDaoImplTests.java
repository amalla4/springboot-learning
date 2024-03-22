package com.ap.jdbcTemplateTest.dao.impl;

import com.ap.jdbcTemplateTest.TestDataUtil;
import com.ap.jdbcTemplateTest.domain.Book;
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
public class BookDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBookA();

        underTest.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("123-4-5678-9999-0"),
                eq("AP wrote a book."),
                eq(1L)
        );
    }

    @Test
    public void testThatFindOneBookGeneratesCorrectSql(){
        underTest.findOne("123-4-5678-9999-0");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id from books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("123-4-5678-9999-0")
        );
    }

    @Test
    public void testThatFindGeneratesCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id from books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }
}
