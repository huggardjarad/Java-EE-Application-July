package repository;

import java.util.HashMap;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import domain.Account;
import utils.JsonUtil;

@ApplicationScoped
@Alternative 
public class AccountServiceHashImpl implements AccountServiceRepo {

	
	private long id;
	
	@Inject
	private JsonUtil util;
		
	private final Long firstCount = 1L;
	HashMap<Long, Account> accountMap;
	
	public AccountServiceHashImpl() {
		this.accountMap = new HashMap<Long, Account>();
		id = firstCount;
		initAccountMap();
	}

	public String findAllAccounts(){
		return util.getJsonForObject(accountMap.values());
	}
	
	public String createAccount(String account) {
		id++;
		Account account1  = util.getObjectForJson(account, Account.class);
		accountMap.put(id, account1);
		return account;
		
	}
	
	public String deleteAccount(Long id) {
		if(accountMap.containsKey(id)) {
			 accountMap.remove(id);
			 return "Account Deleted";
		}
		else {
			return "Account does not exist";
		}
	}
	
	public String updateAccount(Long id, String accountToUpdate) {
		
		Account newAccount = util.getObjectForJson(accountToUpdate, Account.class);
		accountMap.put(id, newAccount);
		
		return accountToUpdate;
			
		}
	private void initAccountMap() {
		Account account = new Account("BillyJo", "Biggins", "65748392");
		accountMap.put(1L, account);
	}

	}


