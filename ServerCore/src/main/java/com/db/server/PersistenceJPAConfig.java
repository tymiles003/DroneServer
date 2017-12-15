package com.db.server;

import com.db.server.jpaVendorAdapters.JpaVendorAdapterBase;
import com.plugins_manager.PluginsManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.ValidationMode;
import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan({ "com.dronedb.persistence", "com.db.persistence" })
@ComponentScan({ "com.db.server" })
@ComponentScan({ "com.db.persistence.wsRest.internal" })
public class PersistenceJPAConfig {

    private final static Logger LOGGER = Logger.getLogger(PersistenceJPAConfig.class);

    public PersistenceJPAConfig() {
        LOGGER.debug("PersistenceJPAConfig Created");
    }

//    @Bean
//    @Lazy
//    public EntityManager createEntityManager(@Autowired EntityManagerFactory entityManagerFactory) {
//        return SharedEntityManagerCreator.createSharedEntityManager(entityManagerFactory);
//    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Autowired DataSource dataSource,
            @Autowired @Qualifier("hibernateJpaVendorAdapter") JpaVendorAdapterBase jpaVendorAdapter)
//            @Autowired @Qualifier("eclipseLinkJpaVendorAdapter") JpaVendorAdapterBase jpaVendorAdapter)
    {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        LOGGER.debug("Set persistence data source: " + dataSource);
        em.setDataSource(dataSource);

        LOGGER.debug("Fetching plugins manager");
        PluginsManager pluginsManager = PluginsManager.getInstance();

        LOGGER.debug("Loading Scheme to DB");
        List<String> schemesLocation = pluginsManager.getSchemes();
        schemesLocation.stream().forEach((scmName) -> LOGGER.debug("Scheme target name: " + scmName));
        String[] schemes = new String[schemesLocation.size()];
        schemes = schemesLocation.toArray(schemes);

        LOGGER.debug("Scan for schemes");
        em.setPackagesToScan(schemes);

        // Setting JPA adapter and it properties
        LOGGER.debug("Setting JPA adapter: " + jpaVendorAdapter.getClass().getCanonicalName());
        em.setJpaVendorAdapter(jpaVendorAdapter);
        LOGGER.debug("Setting JPA properties: " + jpaVendorAdapter.getProperties());
        em.setJpaProperties(jpaVendorAdapter.getProperties());

        //TODO: Remove this limitation, we should enable auto-validate in the future
        // Prevent validation from automatic running during publish by hibernate
        em.setValidationMode(ValidationMode.NONE);

        return em;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}