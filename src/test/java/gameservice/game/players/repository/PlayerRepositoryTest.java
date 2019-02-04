package gameservice.game.players.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import gameservice.game.players.RegisteredGamePlayer;

@RunWith(SpringRunner.class)
public class PlayerRepositoryTest {

	@Test
	public void TestOne() throws InterruptedException {
		RegisteredGamePlayer gp = new RegisteredGamePlayer("Hope");
		PlayerRepositoryImpl repo = new PlayerRepositoryImpl();
		repo.savePlayer(gp);
		Thread.sleep(1000000);
	}
}
