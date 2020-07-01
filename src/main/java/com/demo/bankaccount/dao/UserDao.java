package com.demo.bankaccount.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.bankaccount.model.User;


@Repository
public interface UserDao extends CrudRepository<User, Long> {

	

	Optional<User> findByPanNumber(String panNumber);

	Optional<User> findByCustomerIdAndPassword(String customerId, String password);

	Optional<User> findByUserId(Long userId);

}
