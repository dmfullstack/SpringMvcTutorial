package edu.osumc.bmi.ird.spring.tutorial.test.config;

import edu.osumc.bmi.ird.spring.tutorial.config.PersistenceConfigDev;
import edu.osumc.bmi.ird.spring.tutorial.config.ServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;

/**
 * Created by swang on 3/3/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {/*AppConfig.class,*/PersistenceConfigDev.class,
        ServiceConfig.class})
@ActiveProfiles(profiles = {"dev"})
public class ApplicationContextTest {

    private final static Logger LOG = LoggerFactory.getLogger(ApplicationContextTest.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private PersistenceExceptionTranslationPostProcessor exceptionTranslation;

    @Test
    public void testContextBeans() {
        LOG.info("Testing all bean initialization...");
        assertNotNull(applicationContext);
        assertNotNull(dataSource);
        assertNotNull(transactionManager);
        assertNotNull(entityManagerFactory);
        assertNotNull(exceptionTranslation);
    }
}
