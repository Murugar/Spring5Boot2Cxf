package com.iqmsoft.service;


import java.util.logging.Logger;

@javax.jws.WebService(serviceName = "HelloService", portName = "HelloPort",
        targetNamespace = "http://service.ws.sample/",
        endpointInterface = "com.iqmsoft.service.Hello")
public class HelloPortImpl implements Hello {

    private static final Logger LOG = Logger.getLogger(HelloPortImpl.class.getName());

    public java.lang.String sayHello(java.lang.String myname) {
        LOG.info("Executing operation sayHello" + myname);
        try {
            return "Hello, Welcome to CXF Spring boot " + myname + "!!!";

        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}