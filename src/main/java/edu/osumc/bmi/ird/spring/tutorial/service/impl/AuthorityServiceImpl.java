package edu.osumc.bmi.ird.spring.tutorial.service.impl;

import edu.osumc.bmi.ird.spring.tutorial.persistence.dao.AuthorityDao;
import edu.osumc.bmi.ird.spring.tutorial.persistence.entity.Authority;
import edu.osumc.bmi.ird.spring.tutorial.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Authority Service.
 * Created by swang on 3/4/2015.
 */
@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityDao authorityDao;

    @Override
    public Authority get(Long id) {
        return authorityDao.get(id);
    }

    @Override
    public List<Authority> getAll() {
        return authorityDao.getAll();
    }

    @Override
    public Authority save(Authority authority) {
        return authorityDao.create(authority);
    }
}

