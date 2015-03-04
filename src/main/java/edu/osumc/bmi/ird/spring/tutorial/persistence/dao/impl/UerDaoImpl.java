package edu.osumc.bmi.ird.spring.tutorial.persistence.dao.impl;

import edu.osumc.bmi.ird.spring.tutorial.persistence.dao.UserDao;
import edu.osumc.bmi.ird.spring.tutorial.persistence.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by swang on 3/4/2015.
 */
@Repository("userDao")
public class UerDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {
}
