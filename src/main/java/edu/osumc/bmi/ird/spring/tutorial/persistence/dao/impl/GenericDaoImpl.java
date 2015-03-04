package edu.osumc.bmi.ird.spring.tutorial.persistence.dao.impl;

import edu.osumc.bmi.ird.spring.tutorial.persistence.dao.GenericDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by swang on 3/3/2015.
 */
public abstract class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    private static final Logger LOG = LoggerFactory.getLogger(GenericDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> type;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
        LOG.debug("Parameterized generic type is " + type.getName());
    }

    @Override
    public T create(T persistentObject) {
        entityManager.persist(persistentObject);
        return persistentObject;
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root);

        TypedQuery<T> typedQuery = entityManager.createQuery(query);
        LOG.debug("getAll query is " + query.toString());
        return typedQuery.getResultList();
    }

    @Override
    public T get(PK id) {
        return entityManager.find(type, id);
    }

    @Override
    public T update(T persistentObject) {
        return entityManager.merge(persistentObject);
    }

    @Override
    public void delete(PK id) {
        entityManager.remove(entityManager.getReference(type, id));
    }

    /**
     * Count record number using JPA criteria builder.
     *
     * @param typedQuery the criteria with query root, where clause
     * @return count of the result
     */
    @Override
    public Long countAllByCriteria(TypedQuery<Long> typedQuery) {
        return typedQuery.getSingleResult();
    }

    /**
     * Find all records using JPA criteria builder.
     *
     * @param typedQuery the criteria with query root, where clause and order by
     * @return List of the result objects
     */
    @Override
    public List<T> findAllByCriteria(TypedQuery<T> typedQuery) {
        return typedQuery.getResultList();
    }
}
