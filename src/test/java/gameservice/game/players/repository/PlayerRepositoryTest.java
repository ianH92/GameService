package gameservice.game.players.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	private PlayerRepository playerRepository;
	
	@Test
	public void testSave() throws InterruptedException {
		Player player = new RegisteredGamePlayer("p1");
		playerRepository.savePlayer(player);
		
		Player savedPlayer = playerRepository.findPlayer("p1");
		
		assertTrue(savedPlayer != null);
		assertEquals("p1", ((RegisteredGamePlayer) savedPlayer).getUsername());
		
		playerRepository.deletePlayer(savedPlayer);
	}
	
	@Test
	public void testFindByUsername() {
		Player player = new RegisteredGamePlayer("p1");
		playerRepository.savePlayer(player);
		
		Player playerFoundByUsername = playerRepository.findPlayer("p1");
		
		assertEquals("p1", ((RegisteredGamePlayer) playerFoundByUsername).getUsername());
		
		playerRepository.deletePlayer(playerFoundByUsername);
	}
	
	@Test
	public void testFindById() {
		Player player = new RegisteredGamePlayer("p1");
		playerRepository.savePlayer(player);
		
		Player playerFoundByUsername = playerRepository.findPlayer("p1");
		Player playerFoundById = playerRepository.findPlayer(playerFoundByUsername.getId());
		
		assertEquals(playerFoundByUsername.getId(), playerFoundById.getId());
		
		playerRepository.deletePlayer(playerFoundById);
	}
	
	@Test
	public void testDelete() {
		Player player = new RegisteredGamePlayer("p1");
		playerRepository.savePlayer(player);
		
		Player playerFoundByUsername = playerRepository.findPlayer("p1");
		playerRepository.deletePlayer(playerFoundByUsername);
		
		Player deletedPlayer = playerRepository.findPlayer(playerFoundByUsername.getId());
		System.out.println("deletedPlayer = " + deletedPlayer);
		
		assertTrue(deletedPlayer == null);
	}
}
