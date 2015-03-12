package edu.osumc.bmi.ird.spring.tutorial.service;

import edu.osumc.bmi.ird.spring.tutorial.persistence.entity.User;

import java.util.List;

/**
 * Created by swang on 3/4/2015.
 */
public interface UserService {

    User create(User user);

    User get(Long id);

    User update(User user);

    void delete(Long id);

    User findByUsername(String username);

    List<User> getAll();
}
