package gameservice;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class GameService implements CommandLineRunner {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		SpringApplication.run(GameService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("HERE");
		if(sessionFactory == null) {
			System.out.println("Session factory is null");
		}
		
	}
}
