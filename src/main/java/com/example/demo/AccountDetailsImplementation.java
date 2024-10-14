package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDetailsImplementation implements AccountDetails{

    private EntityManager entityManager;

    @Autowired
    public AccountDetailsImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Account theAccount) {
        entityManager.persist(theAccount);
    }

    @Override
    public Account findById(int theId) {
        return entityManager.find(Account.class, theId);
    }

    @Override
    public List<Account> findAll() {
        TypedQuery<Account> theQuery =entityManager.createQuery("FROM Account", Account.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Account> findByLastName(String theLastName) {
        TypedQuery<Account> theQuery = entityManager.createQuery("FROM Account WHERE lastname =:theData", Account.class);
        theQuery.setParameter("theData", theLastName);
        return theQuery.getResultList();
    }

    @Override
    public void update(Account myAccount) {
        entityManager.merge(myAccount);
    }

    @Override
    public void delete(int theAccountNumber) {
        Account theAccount =entityManager.find(Account.class, theAccountNumber);
        entityManager.remove(theAccount);
    }
}
