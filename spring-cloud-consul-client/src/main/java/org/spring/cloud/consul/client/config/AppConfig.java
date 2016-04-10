package org.spring.cloud.consul.client.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration
@EnableAutoConfiguration 
@ComponentScan("org.spring.cloud.consul")
public class AppConfig {

}
