package edu.osumc.bmi.ird.spring.tutorial.persistence.dao;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by swang on 3/3/2015.
 */
public interface GenericDao<T, PK extends Serializable> {

    T create(T persistentObject);

    List<T> getAll();

    T get(PK id);

    T update(T persistentObject);

    void delete(PK id);

    /**
     * Count record number using JPA criteria builder.
     *
     * @param typedQuery the criteria with query root, where clause
     * @return count of the result
     */
    Long countAllByCriteria(TypedQuery<Long> typedQuery);

    /**
     * Find all records using JPA criteria builder.
     *
     * @param typedQuery the criteria with query root, where clause and order by
     * @return List of the result objects
     */
    List<T> findAllByCriteria(TypedQuery<T> typedQuery);
}
