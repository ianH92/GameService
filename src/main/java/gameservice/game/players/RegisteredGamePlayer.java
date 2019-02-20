package gameservice.game.players;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

/**
 * 
 * @author ianH92
 *
 */
@Getter
@Entity
public class RegisteredGamePlayer implements Player {
	
	public RegisteredGamePlayer() {}
	
	public RegisteredGamePlayer(String username) {
		this.username = username;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String username;
}
