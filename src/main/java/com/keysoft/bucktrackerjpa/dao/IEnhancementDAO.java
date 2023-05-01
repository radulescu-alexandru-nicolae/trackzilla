package com.keysoft.bucktrackerjpa.dao;

import com.keysoft.bucktrackerjpa.entity.Enhancement;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

public interface IEnhancementDAO {

    void addEnhancement(Enhancement enhancement);
}
