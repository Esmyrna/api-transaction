package spring_boot.desafio.transactionApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioApiTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApiTransactionApplication.class, args);
	}

}
