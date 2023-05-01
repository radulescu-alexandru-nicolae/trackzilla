package com.keysoft.bucktrackerjpa.dao;

import com.keysoft.bucktrackerjpa.entity.Enhancement;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class EnhancementDAO implements IEnhancementDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addEnhancement(Enhancement enhancement) {
        entityManager.persist(enhancement);
    }
}
