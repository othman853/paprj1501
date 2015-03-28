package br.com.othman853.paprj1501.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.othman853.paprj1501.dao.UserDao;
import br.com.othman853.paprj1501.model.User;

@Resource
public class UserController {
	
	private UserDao dao;
	private Result result;
	
	public UserController(UserDao dao, Result result) {
		this.dao = dao;
		this.result = result;
	}
	
	@Path("/cadastro")
	public void register(){		
	}
	
	public void register(User user){
		result.include(user);
	}
	
	
	@Post
	public void save(User user){
		dao.saveOrUpdate(user);
		result.redirectTo(this).register();
	}	
	
	@Path("/alterar/{id}")
	public void alter(long id){
		User user = dao.find(id);
		result.redirectTo(this).register(user);
	}
	
	@Path("/usuario/{id}")
	public void show(long id){
		
	}

}
