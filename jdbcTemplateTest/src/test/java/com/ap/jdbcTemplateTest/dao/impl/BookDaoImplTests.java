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


    //====================== CREATE TESTS ===========================//
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

    //====================== READ TESTS ===========================//
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

    //====================== UPDATE TESTS ===========================//
    @Test
    public void testThatUpdateGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBookA();
        underTest.update("123-4-5678-9999-0", book);

        verify(jdbcTemplate).update(
                "UPDATE books SET isbn=?, title=?, author_id=? WHERE isbn=?",
                "123-4-5678-9999-0", "AP wrote a book.", 1L, "123-4-5678-9999-0"
        );
    }

    //====================== DELETE TESTS ===========================//
    @Test
    public void testThatDeleteGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBookA();
        underTest.delete("123-4-5678-9999-0");

        verify(jdbcTemplate).update(
                "DELETE from books where isbn=?",
                "123-4-5678-9999-0"
        );
    }
}
