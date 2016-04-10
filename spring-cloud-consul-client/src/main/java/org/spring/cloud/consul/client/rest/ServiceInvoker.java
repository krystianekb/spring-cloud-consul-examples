package org.spring.cloud.consul.client.rest;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.cloud.consul.client.discovery.ServiceUriProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ServiceInvoker {

	private static final Logger LOG = LoggerFactory.getLogger(ServiceInvoker.class);
	
	@Autowired
	private ServiceUriProvider serviceProvider;
		
	
	@Scheduled(fixedDelay=5000)
	public void invoke() {		
		URI uri = serviceProvider.serviceUri();
		LOG.info("Using URI: {}", uri.toString());
		
	}
	
	
}
