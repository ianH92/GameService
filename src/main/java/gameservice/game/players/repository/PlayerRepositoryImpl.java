package gameservice.game.players.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import gameservice.game.players.Player;

public class PlayerRepositoryImpl implements PlayerRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savePlayer(Player player) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.persist(player);
		transaction.commit();
		session.close();
	}

	@Override
	public Player findPlayer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
