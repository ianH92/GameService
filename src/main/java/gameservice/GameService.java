package gameservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan
@EnableTransactionManagement
public class GameService {
	
	public static void main(String[] args) {
		SpringApplication.run(GameService.class, args);
	}
}
