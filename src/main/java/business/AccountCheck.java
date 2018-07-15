package business;


import domain.Account;

public class AccountCheck {
	
	
	
	public boolean accountCheck(Account account) {
		
		if (account.getAccountNumber().equals("99999999")) {
			
			return false;
		}else {
			return true;
		}
		
	}
}
	

