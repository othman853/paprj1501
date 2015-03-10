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
	private Session session;
	
	public FirstController(Result result){
		this.result = result;		
	}
	
	@Path("/")
	public void first(){
		result.include("message", "hello Vraptor");
	}
	
	@Get("/hiber/{text}")
	public void testHibernate(String text){
		
		Transaction tx = session.beginTransaction();
		session.save(new HelloHibernate(text));
		tx.commit();	
		
		session.close();
		
		result.redirectTo(this).list();
	}
	
	
	public List<HelloHibernate> list(){
		
		List<HelloHibernate> list;
		
		list = session.createCriteria(HelloHibernate.class).list();
		
		
		for(HelloHibernate hib : list){
			System.out.println(hib.getHelloText());
		}
		
		return list;		
	}
}