package repository;


public interface AccountServiceRepo {
	
	public String findAllAccounts();
	
	public String createAccount(String account); 
	
	public String deleteAccount(Long id);
	
	public String updateAccount(Long id, String accountToUpdate);
	
} 
