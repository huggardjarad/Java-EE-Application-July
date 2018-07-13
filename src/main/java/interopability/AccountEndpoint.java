package interopability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import business.AccountService;


@Path("/account")
public class AccountEndpoint {

	@Inject
	private AccountService service;
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String findAllAccounts()	{
		return service.findAllAcounts();
	}
	
	
	@Path("/json")
	@POST
	@Produces({"application/json"})
	public String createAccount(String account) {
		return service.createAccount(account);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateAccount(@PathParam("id") Long id, String accountToUpdate){
			return service.updateAccount(id, accountToUpdate);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteAccount(@PathParam("id") Long id) {
		return service.deleteAccount(id);
	}
}

