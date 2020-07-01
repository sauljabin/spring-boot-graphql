package app.common.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "app")
public class SpringBootGraphQLApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphQLApplication.class, args);
	}

}
