package ru.sibsutis.dormitory.server.app;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.sibsutis.dormitory.server.app.utils.ApplicationUtils;


import static org.slf4j.LoggerFactory.getLogger;

@SuppressWarnings({"checkstyle:finalclass", "checkstyle:hideutilityclassconstructor"})
@SpringBootApplication
@PropertySource(value = "classpath:dorm-automation.properties", encoding = "UTF-8")
@ComponentScan(basePackages = {"ru.sibsutis.dormitory.server"})
@EntityScan("ru.sibsutis.dormitory.server.model.entity")
public class Starter {

    private static final Logger LOG = getLogger(Starter.class);

    /**
     * Запуск SpringBoot Application
     * @param args command-line args
     */
    public static void main(final String[] args) {
        SpringApplication.run(Starter.class, args);
        LOG.info("APPLICATION STARTED: version - " + ApplicationUtils.getVersion());
    }

}
