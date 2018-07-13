package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Transactions {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "TRANSACTIONID")
	private Long id;
	@Column(name = "TRANSACTIONREF", length = 50)
	private String transactionReference;
	
	@ManyToOne
	@JoinColumn(name = "ACCOUNT", referencedColumnName = "ACCOUNTID")
	private Account account;
	
	
	public Transactions(Long id, String transactionReference) {
		this.id = id;
		this.transactionReference = transactionReference;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTransactionReference() {
		return transactionReference;
	}
	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}

}
