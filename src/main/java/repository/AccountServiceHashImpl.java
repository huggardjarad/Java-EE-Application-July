package repository;

import java.util.HashMap;
import java.util.List;

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
		
	
	HashMap<Long, Account> accountMap;
	List<Account> accountList;

	public String findAllAccounts(){
		return util.getJsonForObject(accountMap.values());
	}
	
	public String createAccount(String account) {
		
		Account account1  = util.getObjectForJson(account, Account.class);
		accountMap.put(id, account1);
		return "{\"message\": \"account sucessfully added\"}";
		
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
		return util.getJsonForObject(accountMap.values());
			
		}

	}


