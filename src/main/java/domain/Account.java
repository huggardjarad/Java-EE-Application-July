package domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.validation.constraints.Size;


@Entity
public class Account {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ACCOUNTID")
	private Long id;
	@Column(name = "FIRSTNAME", length = 25)
	private String firstName;
	@Column(name = "LASTNAME", length = 25)
	private String lastName;
	@Column(name = "ACCOUNTNUMBER")
	@Size(min = 8, max = 8)
	private String accountNumber;
	
	public Account() {}
	
	public Account(String firstName, String lastName, String accountNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
