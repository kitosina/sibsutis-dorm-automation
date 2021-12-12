package ru.sibsutis.dormitory.server.app.config;

import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@RequiredArgsConstructor
@Configuration
@PropertySource(value = "classpath:dorm-automation.properties", encoding = "UTF-8")
public class LiquibaseConfig {

    @Qualifier("dormDataSource")
    private final DataSource dormDataSource;

    /**
     * Путь к файлу с журналами изменений
     */
    @Value("${dorm.liquibase.sql.migrate}")
    private String pathChangeLog;

    /**
     * Таблица с версионированием скриптов
     */
    private String changeLogTable = "liquibase_changelog";

    /**
     * Таблица для блокировки журнала изменений
     */
    private String changeLogLockTable = "liquibase_changeloglock";

    /**
     * Схема для таблиц версионирования (liquibase_changelog, liquibase_changeloglock)
     */
    private String liquibaseSchemaVersion = "public";

    /**
     * Установка настроек для миграции в spring liquibase
     * @return SpringLiquibase
     */
    @Bean
    public SpringLiquibase liquibase()  {
        SpringLiquibase liquibase = new SpringLiquibase();

        liquibase.setDataSource(dormDataSource);
        liquibase.setDatabaseChangeLogTable(changeLogTable);
        liquibase.setDatabaseChangeLogLockTable(changeLogLockTable);
        liquibase.setLiquibaseSchema(liquibaseSchemaVersion);
        liquibase.setChangeLog(pathChangeLog);

        return liquibase;
    }


}
