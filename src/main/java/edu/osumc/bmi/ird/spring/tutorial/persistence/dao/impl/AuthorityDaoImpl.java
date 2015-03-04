package edu.osumc.bmi.ird.spring.tutorial.persistence.dao.impl;

import edu.osumc.bmi.ird.spring.tutorial.persistence.dao.AuthorityDao;
import edu.osumc.bmi.ird.spring.tutorial.persistence.entity.Authority;
import org.springframework.stereotype.Repository;

/**
 * Created by swang on 3/4/2015.
 */
@Repository("authorityDao")
public class AuthorityDaoImpl extends GenericDaoImpl<Authority, Long> implements AuthorityDao {
}
