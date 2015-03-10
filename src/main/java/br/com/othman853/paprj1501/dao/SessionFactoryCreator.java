package br.com.othman853.paprj1501.dao;

import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;


public class SessionFactoryCreator implements ComponentFactory<SessionFactory>{
	
	private SessionFactory factory;
	
	public SessionFactoryCreator() {
		create();
	}
	
	private void create(){
		Configuration configuration = new Configuration();
		
		configuration.setProperty("hibernate.connection.url", System.getenv("PAPRJ1501_DB_URL"));
		configuration.setProperty("hibernate.connection.username", System.getenv("PAPRJ1501_DB_USER"));
		configuration.setProperty("hibernate.connection.password", System.getenv("PAPRJ1501_DB_PASS"));
		configuration.configure();
		
		factory = configuration.buildSessionFactory();
	}

	@Override
	public SessionFactory getInstance() {
		return factory;
	}
	
	@PreDestroy
	public void destroy(){
		factory.close();
	}

}
