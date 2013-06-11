package ar.edu.unq.tpi.tip.example;

import org.uqbar.commons.utils.TransactionalAndObservable;

@TransactionalAndObservable
public class Transaction {
	
	public static final String SOURCE = "source";
	public static final String DESTINATION = "destination";
	public static final String AMOUNT = "amount";
	
	private Account source;
	private Account destination;
	private Long amount;

	public Transaction() {
	}
	
	public Transaction(final Account source, final Account destination, final Long amount) {
		this.source = source;
		this.destination = destination;
		this.amount = amount;
	}
	
	public void execute(){
		source.withdraw(amount);
		destination.deposit(amount);
	}

	public Account getSource() {
		return source;
	}

	public Account getDestination() {
		return destination;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public void setDestination(Account destination) {
		this.destination = destination;
	}

	public void setSource(Account source) {
		this.source = source;
	}
	
	public void clear(){
		this.amount =null ;
		this.source = null;
		this.destination = null;
	}
	
	@Override
	public String toString() {
		return "source: "+source + " destiny: " + destination + " amount: "+amount;
	}

}
