package gameservice.game.players.repository;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import gameservice.game.players.Player;
import gameservice.game.players.RegisteredGamePlayer;
import gameservice.hibernate.configuration.HibernateConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(
	classes = { HibernateConfiguration.class, PlayerRepositoryImpl.class },
	loader =  AnnotationConfigContextLoader.class)
@Transactional
public class PlayerRepositoryTest {
	
	@Autowired
	private PlayerRepository pri;
	
	@Test
	public void TestOne() throws InterruptedException {
		Player p = new RegisteredGamePlayer("p1");
		pri.savePlayer(p);
	}
}
