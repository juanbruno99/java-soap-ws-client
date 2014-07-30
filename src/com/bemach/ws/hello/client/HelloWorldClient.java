package com.bemach.ws.hello.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.bemach.ws.hello.HelloWorld;
import com.bemach.ws.hello.HelloWorldService;

public class HelloWorldClient {
	private static final Logger log = Logger.getLogger(HelloWorldClient.class.getName());
	
	public static void main(String[] args) {
		HelloWorldClient client = new HelloWorldClient();
		try {
			client.say("Peluca");
		} catch (Exception e) {
			log.log(Level.SEVERE, "Severe error..." + e);
		}
	}
	
	public void say(String name) throws MalformedURLException {
		log.info("Service...");
		QName qname = new QName("http://hello.ws.bemach.com/", "HelloWorldService"); //schema namespace
		URL url = new URL("http://macbook-pro-de-juan.local:8080/java-ws/HelloWorldService"); //url endpoint
		Service service = HelloWorldService.create(url, qname); //service
		HelloWorld port = service.getPort(HelloWorld.class); //port
		String returnMessage = port.say(name); //call operation on port
		
		log.info("Return Message: " + returnMessage);
	}
}
