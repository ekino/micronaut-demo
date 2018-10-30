package com.ekino.micronaut.borrowing.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static java.nio.file.Files.readAllBytes;
import static java.util.Arrays.stream;

abstract class AbstractIT {

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    private Consumer<String> runScript = scriptName -> {
        try {
            EntityTransaction transaction = getActiveTransaction();

            String sqlResourcePath = getClass().getClassLoader()
                    .getResource(scriptName)
                    .getPath();
            Path sqlFilePath = new File(sqlResourcePath).toPath();

            entityManager.createNativeQuery(new String(readAllBytes(sqlFilePath)))
                    .executeUpdate();

            transaction.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    @AfterEach
    void cleanup() {
        entityManager.close();
    }

    void runSql(String... sqlFileNames) {
        stream(sqlFileNames).forEach(runScript);
    }

    @BeforeEach
    void setup() {
        entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = getActiveTransaction();

        entityManager.createNativeQuery("SELECT tablename FROM pg_catalog.pg_tables WHERE schemaname = 'public'")
                .getResultStream()
                .forEach(tableName -> entityManager.createNativeQuery("DELETE FROM \"" + tableName + "\"").executeUpdate());

        transaction.commit();
    }

    private EntityTransaction getActiveTransaction() {
        EntityTransaction transaction = entityManager.getTransaction();

        if (!transaction.isActive()) {
            transaction.begin();
        }

        return transaction;
    }

}
