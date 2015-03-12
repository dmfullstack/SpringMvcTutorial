package edu.osumc.bmi.ird.spring.tutorial.persistence.dao.impl;

import edu.osumc.bmi.ird.spring.tutorial.persistence.dao.UserDao;
import edu.osumc.bmi.ird.spring.tutorial.persistence.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by swang on 3/4/2015.
 */
@Repository("userDao")
public class UerDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {
    @Override
    public User findByUsername(String username) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);

        Path<String> path = root.get("username");
        Predicate predicate = builder.equal(path, username);
        query.where(predicate);

        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }
}
