package fnt.hu.nl.opdracht;

import fnt.hu.nl.opdracht.IHelloWorldApp;

public class HelloWorldApp implements IHelloWorldApp {
	
	
	public HelloWorldApp(String hello) {
		super();
		this.hello = hello;
	}

	public String hello = "";
	
	public String getHello() {
	return hello;
	}
	
	public void setHello(String hello) {
	this.hello = hello;
	}
	
	public String toString() {
	return hello;
	}
   
}