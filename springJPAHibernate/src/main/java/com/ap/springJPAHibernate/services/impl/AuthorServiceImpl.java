package com.ap.springJPAHibernate.services.impl;

import com.ap.springJPAHibernate.domain.entities.AuthorEntity;
import com.ap.springJPAHibernate.repositories.AuthorRepository;
import com.ap.springJPAHibernate.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}
