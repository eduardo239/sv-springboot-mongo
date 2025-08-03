package sv_springboot_mongo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		System.out.println("API Spring Boot com MongoDB iniciada!");
		System.out.println("Acesse http://localhost:8080/produtos para interagir com a API de produtos.");
	}

}
