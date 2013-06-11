package ar.edu.unq.tpi.tip.example.home;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

import ar.edu.unq.tpi.tip.example.Account;
import ar.edu.unq.tpi.tip.example.Client;


public class ClientColeccionImpl extends CollectionBasedHome<Client> {

	public void init() {
		this.create(generateClientWithAccounts(new Client(101010101L, "Dave", "1111", "dave@jappmail.com")));
		this.create(generateClientWithAccounts(new Client(212121212L, "James", "2222", "james@jappmail.com")));
		this.create(generateClientWithAccounts(new Client(3131313131L, "Bruce", "3333", "bruce@jappmail.com")));
		this.create(generateClientWithAccounts(new Client(40404040L, "Phil", "44444", "phil@jappmail.com")));
		this.create(generateClientWithAccounts(new Client(505055050L, "Ozzy", "5555", "ozzy@jappmail.com")));
	}

	private Client generateClientWithAccounts(final Client client) {
		final double random = Math.random()*3;

		for (int i = 0; i < random; i++) {
			new Account((long) (Math.random()*1500), client, (int) (Math.random()*1500));
		}
		
		return client;
	}
	
	public List<Account> getAllAccounts(){
		List<Account> allAccounts = new ArrayList<Account>();
		for (Client client : allInstances()) {
			allAccounts.addAll(client.getAccounts());
		}
		
		return allAccounts;
	}

	public Class<Client> getEntityType() {
		return Client.class;
	}

	public Client createExample() {
		return new Client();
	}


	@Override
	protected Predicate<Client> getCriterio(Client example) {
		return getCriterioTodas();
	}


}
