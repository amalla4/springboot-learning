package com.ap.springJPAHibernate;

import com.ap.springJPAHibernate.domain.dto.AuthorDto;
import com.ap.springJPAHibernate.domain.dto.BookDto;
import com.ap.springJPAHibernate.domain.entities.AuthorEntity;
import com.ap.springJPAHibernate.domain.entities.BookEntity;

public final class TestDataUtil {
    private TestDataUtil() {
    }

    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder().id(1L).name("AP Malla").age(27).build();
    }

    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder().id(2L).name("Jon Cock").age(25).build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder().id(3L).name("Cray Zee").age(69).build();
    }

    public static BookEntity createTestBookEntityA(final AuthorEntity authorEntity) {
        return BookEntity.builder().isbn("123-4-5678-9999-0").title("AP wrote a book.").authorEntity(authorEntity).build();
    }

    public static BookDto createTestBookDtoA(final AuthorDto author) {
        return BookDto.builder().isbn("123-4-5678-9999-0").title("AP wrote a book.").author(author).build();
    }

    public static BookEntity createTestBookB(final AuthorEntity authorEntity) {
        return BookEntity.builder().isbn("222-4-2222-2222-0").title("Second Book the second.").authorEntity(authorEntity).build();
    }

    public static BookEntity createTestBookC(final AuthorEntity authorEntity) {
        return BookEntity.builder().isbn("303-5-9090-8080-1").title("ThirdBook-III.").authorEntity(authorEntity).build();
    }
}
