package com.ap.jdbcTemplateTest;

import com.ap.jdbcTemplateTest.domain.Author;
import com.ap.jdbcTemplateTest.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){}

    public static Author createTestAuthor() {
        return Author.builder().id(1L).name("AP Malla").age(27).build();
    }

    public static Book createTestBook() {
        return Book.builder().isbn("123-4-5678-9999-0").title("AP wrote a book.").authorId(1L).build();
    }
}
