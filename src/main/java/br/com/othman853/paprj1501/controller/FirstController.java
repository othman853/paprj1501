package br.com.othman853.paprj1501.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

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

}
