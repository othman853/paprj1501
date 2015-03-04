package br.com.othman853.paprj1501.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.othman853.paprj1501.model.HelloHibernate;

@Resource
public class FirstController {
	
	private Result result;
	
	public FirstController(Result result){
		this.result = result;
	}
	
	@Path("/")
	public void first(){
		result.include("message", "hello Vraptor");
	}
	
	@Get("/hiber/{text}")
	public void testHibernate(String text){
	
		
		Configuration config = new Configuration();
		
		config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hiber_test");
		config.setProperty("hibernate.connection.username", "padrao");
		config.setProperty("hibernate.connection.password", "pass@word1");
		
		config.configure();
		
		Session session = config.buildSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(new HelloHibernate(text));
		tx.commit();	
		
		session.close();
		
		result.redirectTo(this).list();
	}
	
	
	public List<HelloHibernate> list(){
		
		List<HelloHibernate> list;
		
		Configuration config = new Configuration();
		
		config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hiber_test");
		config.setProperty("hibernate.connection.username", "padrao");
		config.setProperty("hibernate.connection.password", "pass@word1");
		
		config.configure();
		
		Session session = config.buildSessionFactory().openSession();
		list = session.createCriteria(HelloHibernate.class).list();
		session.close();
		
		for(HelloHibernate hib : list){
			System.out.println(hib.getHelloText());
		}
		
		return list;		
	}

}
