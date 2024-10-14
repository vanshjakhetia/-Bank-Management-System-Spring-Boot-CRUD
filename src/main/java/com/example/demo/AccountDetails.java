package com.example.demo;

import java.util.List;

public interface AccountDetails {

    void save(Account theAccount);

    Account findById(int theId);

    List<Account> findAll();

    List<Account> findByLastName(String theLastName);

    void update(Account myAccount);

    void delete(int theAccountNumber);
}
