package business;




public interface AccountService {
	
	public String findAllAcounts();
	
	public String createAccount(String account); 
	
	public String deleteAccount(Long id);
	
	public String updateAccount(Long id, String accountToUpdate);
}
