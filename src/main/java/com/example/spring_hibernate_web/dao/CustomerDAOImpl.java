package com.example.spring_hibernate_web.dao;

import com.example.spring_hibernate_web.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@EnableTransactionManagement
public class CustomerDAOImpl implements CustomerDAO {

  // need to inject the session factory
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  @Transactional
  public List<Customer> getCustomers() {
    // create a query
    TypedQuery<Customer> query = entityManager.createQuery("from Customer", Customer.class);

    // execute query and get result list
    // return the results
    return query.getResultList();
  }
}