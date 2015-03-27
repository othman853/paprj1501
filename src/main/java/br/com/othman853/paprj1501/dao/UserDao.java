package br.com.othman853.paprj1501.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.Resource;
import br.com.othman853.paprj1501.model.User;

@Resource
public class UserDao {
	
	private Session session;
	
	public UserDao(Session session){
		this.session = session;
	}
	
	public void saveOrUpdate(User user){
		System.out.println("Email: " + user.getEmail());		
		System.out.println("Login: " + user.getLogin());
		System.out.println("Name: " + user.getName());
		System.out.println("Password: " + user.getPassword());
		
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
	}
	
	public List<User> all(){
		return session.createCriteria(User.class).list();
	}

}
