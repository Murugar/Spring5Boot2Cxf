package com.iqmsoft.config;

import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;


import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iqmsoft.service.HelloPortImpl;


@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;
    
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new CXFServlet(), "/*");
    }


    @Bean
    public Endpoint endpoint() {

        EndpointImpl endpoint = new EndpointImpl(bus, new HelloPortImpl());
        endpoint.publish("/Hello");
        return endpoint;
    }
}
