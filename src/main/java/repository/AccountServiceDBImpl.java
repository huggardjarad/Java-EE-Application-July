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
public class AccountServiceDBImpl implements AccountServiceRepo {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JsonUtil util;  
	
	public String findAllAccounts(){
		TypedQuery<Account> query = manager.createQuery("SELECT a FROM Account a", Account.class);
		
		List<Account> account = query.getResultList();
		
		return util.getJsonForObject(account);
	}
	
	public Account getAnAccount(Long id) {
		return manager.find(Account.class, id) ;
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
	public String updateAccount(Long id, String accountToUpdate){
		Account updatedAccount = util.getObjectForJson(accountToUpdate, Account.class);
		Account accountFromDB = getAnAccount(id);
		if (accountToUpdate != null) {
			accountFromDB = updatedAccount;
			accountFromDB.setId(id);
			manager.merge(accountFromDB);
		}
	
		return "{\"message\": \"account sucessfully updated\"}";
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JsonUtil util) {
		this.util = util;
	}
}
