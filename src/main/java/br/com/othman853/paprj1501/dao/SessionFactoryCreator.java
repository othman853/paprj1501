package br.com.othman853.paprj1501.dao;

import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class SessionFactoryCreator implements ComponentFactory<SessionFactory>{
	
	private SessionFactory factory;
	
	public SessionFactoryCreator() {
		create();
	}
	
	private void create(){
		Configuration configuration = new Configuration();
		
		URI dbUri;
		try {
			dbUri = new URI(System.getenv("DATABASE_URL"));
			
		    String username = dbUri.getUserInfo().split(":")[0];
		    String password = dbUri.getUserInfo().split(":")[1];
		    String url = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();		    
			
			configuration.setProperty("hibernate.connection.url", url);				
			configuration.setProperty("hibernate.connection.username", username);
			configuration.setProperty("hibernate.connection.password", password);
			configuration.configure();			
			
			factory = configuration.buildSessionFactory();
		} catch (URISyntaxException e) {			
			e.printStackTrace();
		}
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
