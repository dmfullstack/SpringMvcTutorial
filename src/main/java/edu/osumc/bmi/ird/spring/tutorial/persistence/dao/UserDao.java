package edu.osumc.bmi.ird.spring.tutorial.persistence.dao;

import edu.osumc.bmi.ird.spring.tutorial.persistence.entity.User;

/**
 * Created by swang on 3/3/2015.
 */
public interface UserDao extends GenericDao<User, Long> {
    User findByUsername(String username);
}
