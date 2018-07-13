package business;

import domain.Account;

public class AccountCheck {
	
	public String accountCheck(Account account) {
		
		if (account.getAccountNumber().equals("99999999")) {
			
			return "{\"message\": \"account is blocked!\"}";
		}else {
			 return "{\"message\": \"account sucessfully added\"}";
		}
	}
	
}
