package co.zhanglintc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaCenter7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaCenter7001.class, args);
    }
}