package com.ekino.micronaut.book.config;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;

import io.micronaut.context.annotation.Value;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.event.ApplicationStartupEvent;
import org.flywaydb.core.Flyway;

@Singleton
public class FlywayConfig implements ApplicationEventListener<ApplicationStartupEvent> {

    @Inject
    private DataSource dataSource;

    @Value("${flyway.locations}")
    private String[] locations;

    @Override
    public void onApplicationEvent(ApplicationStartupEvent event) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setLocations(locations);
        flyway.clean();
        flyway.migrate();
    }
}
