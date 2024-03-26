package com.ap.springJPAHibernate.repositories;

import com.ap.springJPAHibernate.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
