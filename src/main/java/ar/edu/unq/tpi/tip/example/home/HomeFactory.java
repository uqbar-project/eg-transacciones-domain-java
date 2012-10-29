package ar.edu.unq.tpi.tip.example.home;

import java.util.Map;

import org.uqbar.commons.model.Home;

public interface HomeFactory {

	void addHomes(Map<Class<?>, Home<?>> homes);

}
