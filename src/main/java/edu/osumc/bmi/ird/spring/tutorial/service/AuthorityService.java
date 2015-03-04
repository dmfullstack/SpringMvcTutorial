package edu.osumc.bmi.ird.spring.tutorial.service;

import edu.osumc.bmi.ird.spring.tutorial.persistence.entity.Authority;

import java.util.List;

/**
 * Created by swang on 3/4/2015.
 */
public interface AuthorityService {
    
    Authority get(Long id);

    List<Authority> getAll();

    Authority save(Authority authority);
}
