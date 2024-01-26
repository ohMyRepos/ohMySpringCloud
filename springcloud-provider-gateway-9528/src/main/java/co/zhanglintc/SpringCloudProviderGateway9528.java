package co.zhanglintc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudProviderGateway9528 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderGateway9528.class, args);
    }
}