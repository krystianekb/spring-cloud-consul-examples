package consul1;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class ServerTest {

    @RequestMapping("/helloworld")
    public String helloWorld() {
        return "Hello world";
    }
    
    @RequestMapping("/health")
    public String health() {
        return "OK";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServerTest.class).web(true).run(args);
    }

}
