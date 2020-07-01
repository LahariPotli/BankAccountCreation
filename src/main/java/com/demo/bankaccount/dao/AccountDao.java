package com.demo.bankaccount.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.bankaccount.model.Account;
import com.demo.bankaccount.model.User;
/**
 * @author Haritha
 *
 */
@Repository
public interface AccountDao extends CrudRepository<Account, Long>{
/**
 * This method is used to get list of account details by userId
 * @param user
 * @return list of account details
 */
Optional<List<Account>> findByUser(User user);
}
