package br.edu.infnet.appEduardoSantos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppEduardoSantosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppEduardoSantosApplication.class, args);
	}

}
