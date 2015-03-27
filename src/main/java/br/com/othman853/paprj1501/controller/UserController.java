package br.com.othman853.paprj1501.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.othman853.paprj1501.dao.UserDao;
import br.com.othman853.paprj1501.model.User;

@Resource
public class UserController {
	
	private UserDao dao;
	
	public UserController(UserDao dao) {
		this.dao = dao;
	}
	
	@Path("/cadastro")
	public void register(User user){				
		dao.saveOrUpdate(user);
	}
	
	@Path("/alterar/{id}")
	public void alter(long id){
		
	}
	
	@Path("/usuario/{id}")
	public void show(long id){
		
	}

}
