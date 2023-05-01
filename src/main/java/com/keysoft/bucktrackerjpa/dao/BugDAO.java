package com.keysoft.bucktrackerjpa.dao;

import com.keysoft.bucktrackerjpa.entity.Bug;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class BugDAO implements IBugDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBug(Bug bug) {
       entityManager.persist(bug);
    }
}
