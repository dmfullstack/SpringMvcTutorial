package edu.osumc.bmi.ird.spring.tutorial.service.impl;

import edu.osumc.bmi.ird.spring.tutorial.persistence.dao.AuthorityDao;
import edu.osumc.bmi.ird.spring.tutorial.persistence.entity.Role;
import edu.osumc.bmi.ird.spring.tutorial.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Role Service.
 * Created by swang on 3/4/2015.
 */
@Transactional
@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityDao authorityDao;

    @Override
    public Role get(Long id) {
        return authorityDao.get(id);
    }

    @Override
    public List<Role> getAll() {
        return authorityDao.getAll();
    }

    @Override
    public Role save(Role authority) {
        return authorityDao.create(authority);
    }
}

