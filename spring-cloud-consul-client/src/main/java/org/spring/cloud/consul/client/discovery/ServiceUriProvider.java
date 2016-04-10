/**
 * 
 */
package org.spring.cloud.consul.client.discovery;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

/**
 * @author Krystian
 *
 */
@EnableDiscoveryClient
@Component
public class ServiceUriProvider {

	private static final Logger LOG = LoggerFactory.getLogger(ServiceUriProvider.class); 
	
	@Autowired
	@Named("consulDiscoveryClient")
	DiscoveryClient discoveryClient;
	
	@Value("${service.name:HelloWorldService}")
	private String serviceName;

	private String toStringList(List<?> list) {
		return (String)list.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
	}
	
	public URI serviceUri() {
		LOG.info("Available services: {} ", toStringList(discoveryClient.getServices()));
		LOG.info("Asking for service under: {}", serviceName);
	    List<ServiceInstance> list = discoveryClient.getInstances(serviceName);
	    if (list != null && list.size() > 0 ) {
	    	LOG.debug("Discovered following instances : {}", toStringList(list));
	        return list.get(0).getUri();
	    }
	    return null;
	}
	
}
