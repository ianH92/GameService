package gameservice.game.players.repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gameservice.game.players.Player;

@Repository
@Transactional
public class PlayerRepositoryImpl implements PlayerRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savePlayer(Player player) {
		Session session = this.sessionFactory.openSession();
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
