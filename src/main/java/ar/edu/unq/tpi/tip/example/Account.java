package ar.edu.unq.tpi.tip.example;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.TransactionalAndObservable;

@TransactionalAndObservable
public class Account extends Entity{
	private static final long serialVersionUID = 1L;
	
	public static final String BALANCE = "balance";
	public static final String OWNER = "owner.name";
	public static final String ID = "id";
	private static final int MAX_DEPOSIT = 500;

	private Long balance;
	private Client owner;
	
	public Account() {
	}
	
	public Account(Client client){
		this.owner = client;
		owner.addAccount(this);
	}
	
	public Account(final Long balance, final Client owner, final Integer id) {
		this(owner);
		this.balance = balance;
		this.setId(id);
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public void withdraw(Long amount) {
		if(balance < amount){
			throw new UserException("No te da la nasta pibe");			
		}

		balance -= amount;
	}

	public void deposit(Long amount) {
		if(amount > MAX_DEPOSIT){
			throw new UserException("No podes depositar mas de $"+MAX_DEPOSIT );
		}
		balance += amount;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}
	
	
	@Override
	public String toString() {
		return "Account -> owner: "+owner + " balance: "+balance;
	}
	
	
}
