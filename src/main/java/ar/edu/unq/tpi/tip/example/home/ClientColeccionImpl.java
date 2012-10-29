package ar.edu.unq.tpi.tip.example.home;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

import ar.edu.unq.tpi.tip.example.Account;
import ar.edu.unq.tpi.tip.example.Client;


public class ClientColeccionImpl extends CollectionBasedHome<Client> {

	public void init() {
		this.create(generateClientWithAccounts(new Client(101010101L, "Juan", "1111", "juan@jappmail.com")));
		this.create(generateClientWithAccounts(new Client(212121212L, "Ragna", "2222", "ragna@jappmail.com")));
		this.create(generateClientWithAccounts(new Client(3131313131L, "Pepito", "3333", "pepito@jappmail.com")));
		this.create(generateClientWithAccounts(new Client(40404040L, "Fulano", "44444", "fulano@jappmail.com")));
		this.create(generateClientWithAccounts(new Client(505055050L, "Mengano", "5555", "mengano@jappmail.com")));
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
