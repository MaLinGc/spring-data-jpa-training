package com.ml.repositories;

import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@NoRepositoryBean
public abstract class BaseRepository {

    @PersistenceContext
    protected EntityManager em;

}
