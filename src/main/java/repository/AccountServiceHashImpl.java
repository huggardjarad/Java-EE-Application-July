package repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import domain.Account;
import utils.JsonUtil;

@Alternative 
public class AccountServiceHashImpl implements AccountServiceDBRepo {

	HashMap<Long, Account> accountMap;
	List<Account> accountList;
	
	@Inject
	private JsonUtil util;
	
	private long id;

	public Account getAnAccount(Long id) {
		
		if (accountMap.containsKey(id)) {
			return accountMap.get(id);
		}
		else {
			return accountMap.get(id);
		}
	}
	public List<Account> findAllAccounts(){
		Iterator<Entry<Long, Account>> accountIterator = accountMap.entrySet().iterator();
		while(accountIterator.hasNext()) {
		HashMap.Entry<Long, Account> account = (HashMap.Entry<Long, Account>) accountIterator.next();
		accountList.add((Account)account);
	}
		return accountList;
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
	
	public String updateAccount(Account account, String firstName, String lastName, String accountNumber) {
			account.setFirstName(firstName);
			account.setLastName(lastName);
			account.setAccountNumber(accountNumber);
			return "Account has been edited.";
		}

	}


