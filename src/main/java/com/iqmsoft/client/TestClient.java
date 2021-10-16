package com.iqmsoft.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import com.iqmsoft.service.Hello;
import com.iqmsoft.service.HelloPortImpl;

public class TestClient {

	public static void main(String[] args) {
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean(); 
		factory.setServiceClass(Hello.class); 
		factory.setAddress("http://localhost:9000/services/Hello"); 
		factory.setUsername("admin");
		factory.setPassword("admin");
		Hello client1 = (Hello) factory.create(); 
		
		Client client =  org.apache.cxf.jaxws.JaxWsClientProxy.getClient(client1);
		
		
		
		HTTPConduit http = (HTTPConduit) client.getConduit();
		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();

		//This is the magic line. Setting this to false solved the problem
		httpClientPolicy.setAllowChunking(false);

		http.setClient(httpClientPolicy);
		
		
		
		String reply = client1.sayHello("test"); 
		System.out.println("Server said: " + reply); 

	}

}
