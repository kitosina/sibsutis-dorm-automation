package ru.sibsutis.dormitory.server.app.config;
import liquibase.pro.packaged.P;
import org.hibernate.SessionFactory;
import org.hibernate.boot.SessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager",
        basePackages = {"ru.sibsutis.dormitory.server.repository"})
public class DormDBConfig {

    /**
     * Получение DataSource в базе dorm
     *
     * @return DataSource -  A factory for connections to the physical data source
     * that this DataSource object represents.
     */
    @Primary
    @Bean(name = "dormDataSource")
    @ConfigurationProperties(prefix = "dorm.datasource")
    public javax.sql.DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * Получение LocalContainerEntityManagerFactoryBean в базе dorm
     *
     * @param builder - builder for JPA EntityManagerFactory instances
     * @param dataSource - factory for connections to the physical data source
     *
     * @return LocalContainerEntityManagerFactoryBean -  FactoryBean that creates
     * a JPA EntityManagerFactory according to JPA's standard container
     * bootstrap contract.
     */
    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            final EntityManagerFactoryBuilder builder,
            @Qualifier("dormDataSource") final DataSource dataSource) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.show_sql", true);
        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages("ru.sibsutis.dormitory.server.model.entity")
                .build();
    }

    /**
     * Получение transaction manager-а в базе dorm
     *
     * @param entityManagerFactory - FactoryBean that creates a JPA EntityManagerFactory
     *
     * @return JpaTransactionManager - Binds a JPA EntityManager from the
     * specified factory to the thread, potentially allowing for one
     * thread-bound EntityManager per factory.
     */
    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") final EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }


}
