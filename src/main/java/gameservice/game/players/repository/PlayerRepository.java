package gameservice.game.players.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gameservice.game.players.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {}
