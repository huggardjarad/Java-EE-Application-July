package repository;

import java.util.List;

import domain.Account;

public interface AccountServiceDBRepo {
	
	public List<Account> findAllAccounts();
	
	public Account getAnAccount(Long id);
	
	public String createAccount(String account); 
	
	public String deleteAccount(Long id);
	
	public String updateAccount(Account account, String firstName, String lastName, String accountNumber);
	
} 
