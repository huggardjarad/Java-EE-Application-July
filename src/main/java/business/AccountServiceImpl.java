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
	
	
	private AccountCheck accountChecker;


	public String createAccount(String account) {
		Account accountJson = util.getObjectForJson(account, Account.class);
		accountChecker.accountCheck(accountJson);
		if (accountChecker.accountCheck(accountJson).equals("{\"message\": \"account is blocked!\"}")) {
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
		
		return repo.updateAccount(id, accountToUpdate);
	}
	
	public void setRepo(AccountServiceRepo repo) {
		this.repo = repo;
	}


	public String findAllAcounts() {
		
	 return repo.findAllAccounts();
	}

}
