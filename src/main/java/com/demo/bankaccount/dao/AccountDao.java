package com.demo.bankaccount.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.bankaccount.model.Account;
@Repository
public interface AccountDao extends CrudRepository<Account, Long>{

}
