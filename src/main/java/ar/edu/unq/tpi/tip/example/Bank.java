package ar.edu.unq.tpi.tip.example;

import java.util.HashMap;
import java.util.Map;

import org.uqbar.commons.model.Application;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.Home;

import ar.edu.unq.tpi.tip.example.home.DefaultPersistentHomeFactory;
import ar.edu.unq.tpi.tip.example.home.HomeFactory;


public class Bank implements Application {
	private static Bank instance;
	private Map<Class<?>, Home<?>> homes;

	@SuppressWarnings("unchecked")
	public synchronized <T extends Entity> Home<T> getHome(Class<? extends T> type) {
		return (Home<T>) this.homes.get(type);
	}

	public static Bank  initialize(HomeFactory factory) {
		instance = new Bank ();
		//HARDCODED: coupled with in-memory homes. 
		Map<Class<?>, Home<?>> homes = new HashMap<Class<?>, Home<?>>();
		factory.addHomes(homes);
		instance.homes = homes;
		return instance;
	}
	
	public static synchronized Bank initialize() {
		return initialize(new DefaultPersistentHomeFactory()); //default is to persist with db4o
//		return initialize(new InMemoryHomeFactory()); //default is to persist with db4o
	}
	
	public static synchronized Bank  getInstance() {
		if (instance == null) {
			instance = initialize();
		}
		return instance;
	}

}
