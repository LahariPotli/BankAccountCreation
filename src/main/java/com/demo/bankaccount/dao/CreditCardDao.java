package com.demo.bankaccount.dao;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.bankaccount.model.CreditCard;
@Repository
public interface CreditCardDao extends CrudRepository<CreditCard, Long>{
	

}
