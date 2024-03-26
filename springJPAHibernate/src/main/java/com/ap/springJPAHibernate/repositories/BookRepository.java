package com.ap.springJPAHibernate.repositories;

import com.ap.springJPAHibernate.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
