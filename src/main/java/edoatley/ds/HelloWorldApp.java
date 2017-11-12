package edoatley.ds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
public class HelloWorldApp {

    @Bean
    NumberGenerator numberGenerator() {
        return new DefaultNumberGenerator();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApp.class, args);
    }
}
