package br.com.othman853.paprj1501.dao;

import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class SessionCreator implements ComponentFactory<Session>{
	
	private Session session;
	private SessionFactory factory;
	
	public SessionCreator(SessionFactory factory) {
		this.factory = factory;
		
		create();
	}
	
	private void create(){
		this.session = factory.openSession(); 
	}

	@Override
	public Session getInstance() {
		return session;
	}
	
	@PreDestroy
	public void destroy(){
		session.close();
	}

}
