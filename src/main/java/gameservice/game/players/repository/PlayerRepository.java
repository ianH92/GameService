package gameservice.game.players.repository;

import gameservice.game.players.Player;

public interface PlayerRepository {
	public void deletePlayer(Player player);
	public void savePlayer(Player player);
	public Player findPlayer(Integer id);
	public Player findPlayer(String username);
}
