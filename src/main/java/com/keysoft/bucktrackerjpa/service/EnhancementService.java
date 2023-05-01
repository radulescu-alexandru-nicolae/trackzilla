package com.keysoft.bucktrackerjpa.service;


import com.keysoft.bucktrackerjpa.dao.EnhancementDAO;
import com.keysoft.bucktrackerjpa.entity.Enhancement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnhancementService implements IEnhancementService {

    @Autowired
    EnhancementDAO enhancementDAO;

    @Override
    public void addEnhancement(Enhancement enhancement){
        enhancementDAO.addEnhancement(enhancement);
    }

}
