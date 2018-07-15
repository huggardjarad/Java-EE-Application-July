package business;

import javax.inject.Inject;


import domain.Account;
import repository.AccountServiceRepo;
import utils.JsonUtil;

public class AccountServiceImpl implements AccountService {


	@Inject
	private AccountServiceRepo repo;
	
	@Inject 
	private JsonUtil util;
	
	@Inject
	private AccountCheck accountChecker;


	public String createAccount(String account) {
		Account accountJson = util.getObjectForJson(account, Account.class);
		if (accountChecker.accountCheck(accountJson) == false) {
			return "Account is blocked";
		}
		else {	
		return repo.createAccount(account);
		} 
	}

	public String deleteAccount(Long id) {
		
		return repo.deleteAccount(id);
	}

	public String updateAccount(Long id, String accountToUpdate) {
		
		Account accountJson = util.getObjectForJson(accountToUpdate, Account.class);
		if (accountChecker.accountCheck(accountJson) == false) {
			return "Account is blocked";
		}
		else {	
		return repo.updateAccount(id, accountToUpdate);
		} 
	}
	
	public void setRepo(AccountServiceRepo repo) {
		this.repo = repo;
	}


	public String findAllAcounts() {
		
	 return repo.findAllAccounts();
	}

}
