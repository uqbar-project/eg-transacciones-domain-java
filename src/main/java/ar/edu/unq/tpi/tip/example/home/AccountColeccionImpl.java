package ar.edu.unq.tpi.tip.example.home;

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

import ar.edu.unq.tpi.tip.example.Account;


public class AccountColeccionImpl extends CollectionBasedHome<Account> {


	public Class<Account> getEntityType() {
		return Account.class;
	}

	public Account createExample() {
		throw new UnsupportedOperationException("no");
	}


	@Override
	protected Predicate<Account> getCriterio(Account example) {
		throw new UnsupportedOperationException("No se puede crear un criterio ");
	}


}
