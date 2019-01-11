package com.ekino.micronaut.book.IT

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import spock.lang.Specification

import javax.inject.Inject
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.EntityTransaction

abstract class AbstractIT extends Specification {

  @Inject
  @Client("/")
  HttpClient client

  @Inject
  private EntityManagerFactory entityManagerFactory

  EntityManager entityManager

  void runSql(String sqlFileName) {
    EntityTransaction transaction = getActiveTransaction()

    String sqlContent = new File(getClass().getClassLoader().getResource(sqlFileName).getText())
    entityManager.createNativeQuery(sqlContent).executeUpdate()

    transaction.commit()
  }

  void init() {
    entityManager = entityManagerFactory.createEntityManager()

    EntityTransaction transaction = getActiveTransaction()

    entityManager.createNativeQuery("DELETE FROM book").executeUpdate()

    transaction.commit()
  }

  private EntityTransaction getActiveTransaction() {
    EntityTransaction transaction = entityManager.getTransaction()

    if (!transaction.isActive()) {
      transaction.begin()
    }
    transaction
  }
}
