package gameservice.game.players;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

/**
 * 
 * @author IAN
 *
 */
@Getter
@Entity
public class RegisteredGamePlayer implements Player {
	
	public RegisteredGamePlayer(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
}
