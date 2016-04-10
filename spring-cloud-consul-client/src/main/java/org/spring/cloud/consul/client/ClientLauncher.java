package org.spring.cloud.consul.client;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ClientLauncher 
{
		
    public static void main( String[] args ) throws Exception
    {
    	ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("org.spring.cloud.consul.client");
    }
}
