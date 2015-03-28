package br.com.othman853.paprj1501.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class PresentationController {
	
	@Path("/")
	public void home(){			
	}
	
	@Path("/sobre")
	public void about(){
	}

}
