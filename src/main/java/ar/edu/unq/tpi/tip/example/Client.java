package ar.edu.unq.tpi.tip.example;

import java.util.ArrayList;
import java.util.List;

import net.sf.oval.configuration.annotation.IsInvariant;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotNull;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.TransactionalAndObservable;

@TransactionalAndObservable
public class Client extends Entity{
	private static final long serialVersionUID = 1L;
	
	private List<Account> accounts = new ArrayList<Account>();
	private String name;
	private String password;
	private String email;
	private Long dni;
	
	public Client() {
	}
	
	public Client(final Long dni, final String name, final String password, final String email) {
		this.dni = dni;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void addAccount(Account account){
		this.accounts.add(account);
	}
	
	public void removeAccount(Account account) {
		this.accounts.remove(account);
	}

	@Length(min = 4, max = 10)
	@IsInvariant
	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Cliente " + this.name + " dni: " + this.dni;
	}

}
