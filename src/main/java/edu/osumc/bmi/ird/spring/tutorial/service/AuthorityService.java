package edu.osumc.bmi.ird.spring.tutorial.service;

import edu.osumc.bmi.ird.spring.tutorial.persistence.entity.Role;

import java.util.List;

/**
 * Created by swang on 3/4/2015.
 */
public interface AuthorityService {

    Role get(Long id);

    List<Role> getAll();

    Role save(Role authority);
}
