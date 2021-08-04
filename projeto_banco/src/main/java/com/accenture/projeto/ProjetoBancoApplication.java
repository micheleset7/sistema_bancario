package com.accenture.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ProjetoBancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBancoApplication.class, args);
	}
	
	@RequestMapping("/home")
	public String Hello() {
		return "hello buddy!";
	}

}
