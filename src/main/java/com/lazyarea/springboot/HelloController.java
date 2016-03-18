package com.lazyarea.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	String[] names = {"lazyarea","taro","hanako"};
	String[] mails = {"k4zuhisa@gmail.com","kazuhisa@lazyarea.com"};
	
	@RequestMapping("/hello")
	public String index(){
		  return "Hello Spring-boot. ";
	}
	
	@RequestMapping("/hello/{id}")
	public DataObject index(@PathVariable int id){
//		return "Hello Spring-boot. " + names[id] + ", " + mails[id];
		return new DataObject(id,names[id],mails[id]);
	}
}

class DataObject {
	private int id;
	private String name;
	private String value;
	
	public DataObject(int id, String name, String value){
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public int getId() { return id; }
	public void setId(int id){ this.id = id;}
	public String getName(){ return name; }
	public void setName(String name){  this.name = name; }
	public String getValue(){ return value; }
	public void setValue(String value){  this.name = value; }
}