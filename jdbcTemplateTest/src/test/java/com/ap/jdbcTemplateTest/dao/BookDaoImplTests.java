package com.ap.jdbcTemplateTest.dao;

import com.ap.jdbcTemplateTest.dao.impl.BookDaoImpl;
import com.ap.jdbcTemplateTest.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
        Book book = Book.builder().isbn("123-4-5678-9999-0").title("AP wrote a book.").authorId(1L).build();

        underTest.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author)id) VALUES (?, ?, ?)"),
                eq("123-4-5678-9999-0"),
                eq("AP wrote a book."),
                eq(1L)
        );
    }
}
