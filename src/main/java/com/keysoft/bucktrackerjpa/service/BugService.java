package com.keysoft.bucktrackerjpa.service;

import com.keysoft.bucktrackerjpa.dao.BugDAO;
import com.keysoft.bucktrackerjpa.entity.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BugService implements IBugService {

    @Autowired
    private BugDAO bugDAO;

    @Override
    public void addBug(Bug bug) {
        bugDAO.addBug(bug);

    }
}
