package com.ap.springJPAHibernate.services;

import com.ap.springJPAHibernate.domain.entities.BookEntity;

public interface BookService {
    BookEntity createBook(String isbn, BookEntity book);
}
