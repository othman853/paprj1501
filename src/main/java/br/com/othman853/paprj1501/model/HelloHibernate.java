package br.com.othman853.paprj1501.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HelloHibernate {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String helloText;

	public HelloHibernate(String helloText) {		
		this.helloText = helloText;
	}
	
	public HelloHibernate(){
		
	}
	
	public String getHelloText(){
		return this.helloText;
	}
}