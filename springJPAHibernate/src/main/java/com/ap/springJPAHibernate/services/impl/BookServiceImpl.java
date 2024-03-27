package com.ap.springJPAHibernate.services.impl;

import com.ap.springJPAHibernate.domain.entities.BookEntity;
import com.ap.springJPAHibernate.repositories.BookRepository;
import com.ap.springJPAHibernate.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }
}
