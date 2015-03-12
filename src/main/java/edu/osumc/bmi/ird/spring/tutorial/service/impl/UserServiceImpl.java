package edu.osumc.bmi.ird.spring.tutorial.service.impl;

import edu.osumc.bmi.ird.spring.tutorial.persistence.dao.UserDao;
import edu.osumc.bmi.ird.spring.tutorial.persistence.entity.User;
import edu.osumc.bmi.ird.spring.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User Service Impl.
 * Created by swang on 3/4/2015.
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
