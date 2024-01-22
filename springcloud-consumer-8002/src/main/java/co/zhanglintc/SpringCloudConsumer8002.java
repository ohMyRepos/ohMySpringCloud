package co.zhanglintc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringCloudConsumer8002 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumer8002.class, args);
    }
}