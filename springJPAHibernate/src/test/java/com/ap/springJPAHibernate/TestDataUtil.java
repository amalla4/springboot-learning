package com.ap.springJPAHibernate;

import com.ap.springJPAHibernate.domain.Author;
import com.ap.springJPAHibernate.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){}

    public static Author createTestAuthorA() {
        return Author.builder().id(1L).name("AP Malla").age(27).build();
    }
    public static Author createTestAuthorB() {
        return Author.builder().id(2L).name("Jon Cock").age(25).build();
    }
    public static Author createTestAuthorC() {
        return Author.builder().id(3L).name("Cray Zee").age(69).build();
    }

    public static Book createTestBookA() {
        return Book.builder().isbn("123-4-5678-9999-0").title("AP wrote a book.").authorId(1L).build();
    }

    public static Book createTestBookB() {
        return Book.builder().isbn("222-4-2222-2222-0").title("Second Book the second.").authorId(1L).build();
    }

    public static Book createTestBookC() {
        return Book.builder().isbn("303-5-9090-8080-1").title("ThirdBook-III.").authorId(1L).build();
    }
}
