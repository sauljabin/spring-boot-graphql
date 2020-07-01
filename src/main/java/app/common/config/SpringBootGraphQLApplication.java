package app.common.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"app"})
@EnableJpaRepositories(basePackages = {"app"})
@EntityScan(basePackages = {"app"})
public class SpringBootGraphQLApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraphQLApplication.class, args);
    }

}
