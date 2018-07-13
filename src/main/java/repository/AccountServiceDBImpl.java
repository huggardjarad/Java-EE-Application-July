package repository;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import domain.Account;
import utils.JsonUtil;

@Default
@Transactional(TxType.SUPPORTS)
public class AccountServiceDBImpl implements AccountServiceDBRepo {
	
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JsonUtil util; 
	

	public List<Account> findAllAccounts(){
		TypedQuery<Account> query = manager.createQuery("SELECT a FROM Account a ORDER BY a.ACCOUNTID DESC", Account.class);
		return query.getResultList();
	}
	public Account getAnAccount(Long id) {
		return manager.find(Account.class, id); 
	}
	
	@Transactional(TxType.REQUIRED)
	public String createAccount(String account) {
		
		Account account1  = util.getObjectForJson(account, Account.class);
		manager.persist(account1);
		return "{\"message\": \"account sucessfully added\"}";
	}
	@Transactional(TxType.REQUIRED)
	public String deleteAccount(Long id) {
		Account accountInDB = getAnAccount(id);
		if(accountInDB != null) {
			manager.remove(accountInDB);
		}
	 return "{\"message\": \"account sucessfully deleted\"}";
	}
	@Transactional(TxType.REQUIRED)
	public String updateAccount(Account account, String firstName, String lastName, String accountNumber){
		account.setFirstName(firstName);
		account.setLastName(lastName);
		account.setAccountNumber(accountNumber);
		manager.refresh(account);
		return "{\"message\": \"account sucessfully updated\"}";
	}
}
