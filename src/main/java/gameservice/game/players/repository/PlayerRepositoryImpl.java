package gameservice.game.players.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gameservice.game.players.Player;
import gameservice.game.players.RegisteredGamePlayer;

@Repository
@Transactional
public class PlayerRepositoryImpl implements PlayerRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savePlayer(Player player) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(player);
		transaction.commit();
		session.close();
	}

	@Override
	public Player findPlayer(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Player player = session.get(RegisteredGamePlayer.class, id);
		
		transaction.commit();
		session.close();
		return player;
	}

	@Override
	public Player findPlayer(String username) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<RegisteredGamePlayer> criteria = builder.createQuery(RegisteredGamePlayer.class);
		Root<RegisteredGamePlayer> root = criteria.from(RegisteredGamePlayer.class);
		criteria.select(root).where(builder.equal(root.get("username"), username));
		Query<RegisteredGamePlayer> query = session.createQuery(criteria);
		Player player = query.getSingleResult();
		
		transaction.commit();
		session.close();
		return player;
	}

	@Override
	public void deletePlayer(Player player) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(player);
		
		transaction.commit();
		session.close();
	}
}
