package com.microservice.account.rest;

import com.microservice.account.model.Account;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class AccountServiceRestController {

	private List<Account> accounts;
	
	protected Logger logger = Logger.getLogger(AccountServiceRestController.class.getName());
	
	public AccountServiceRestController() {
		accounts = new ArrayList<>();
		accounts.add(new Account(1, 1, "111111"));
		accounts.add(new Account(2, 2, "222222"));
		accounts.add(new Account(3, 3, "333333"));
		accounts.add(new Account(4, 4, "444444"));
		accounts.add(new Account(5, 1, "555555"));
		accounts.add(new Account(6, 2, "666666"));
		accounts.add(new Account(7, 2, "777777"));
	}
	
	@RequestMapping("/accounts/customer/{customerId}")
	public List<Account> findByCustomer(@PathVariable("customerId") Integer customerId) {
		logger.info(String.format("Account.findByCustomer(%s)", customerId));
		return accounts.stream().filter(it -> it.getCustomerId().intValue()==customerId.intValue()).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public List<Account> findAll() {
		logger.info("Account.findAll()");
		return accounts;
	}
	
}
