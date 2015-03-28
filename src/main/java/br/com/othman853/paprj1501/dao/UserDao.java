package br.com.othman853.paprj1501.dao;

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
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
	}
	
	public boolean isValidUser(User user){
		
		return true;
	}

	public User find(long id) {
		return (User) session.get(User.class, id);		
	}

}
