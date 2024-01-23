package co.zhanglintc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class SpringCloudProviderHystrix8011 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderHystrix8011.class, args);
    }
}