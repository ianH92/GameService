package gameservice;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import gameservice.game.players.Player;
import gameservice.game.players.RegisteredGamePlayer;
import gameservice.game.players.repository.PlayerRepositoryImpl;

@SpringBootApplication
@ComponentScan
@EnableTransactionManagement
public class GameService implements CommandLineRunner {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PlayerRepositoryImpl plyer;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GameService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("HERE");
		if(sessionFactory == null) {
			System.out.println("Session factory is null");
		}
		if(plyer == null) {
			System.out.println("p is null");
		}
		Player gp = new RegisteredGamePlayer("Hope");
		plyer.savePlayer(gp);
		
	}
}
