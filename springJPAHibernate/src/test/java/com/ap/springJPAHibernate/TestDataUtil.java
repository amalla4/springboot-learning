package com.ap.springJPAHibernate;

import com.ap.springJPAHibernate.domain.Author;
import com.ap.springJPAHibernate.domain.Book;

public final class TestDataUtil {
    private TestDataUtil() {
    }

    public static Author createTestAuthorA() {
        return Author.builder().id(1L).name("AP Malla").age(27).build();
    }

    public static Author createTestAuthorB() {
        return Author.builder().id(2L).name("Jon Cock").age(25).build();
    }

    public static Author createTestAuthorC() {
        return Author.builder().id(3L).name("Cray Zee").age(69).build();
    }

    public static Book createTestBookA(final Author author) {
        return Book.builder().isbn("123-4-5678-9999-0").title("AP wrote a book.").author(author).build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder().isbn("222-4-2222-2222-0").title("Second Book the second.").author(author).build();
    }

    public static Book createTestBookC(final Author author) {
        return Book.builder().isbn("303-5-9090-8080-1").title("ThirdBook-III.").author(author).build();
    }
}
