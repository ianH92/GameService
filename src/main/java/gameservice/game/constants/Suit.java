package gameservice.game.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents the four French suits in a standard 52-card deck
 * 
 * @author ianH92
 *
 */
@AllArgsConstructor
@Getter
public enum Suit {
	HEARTS("H"),
	CLUBS("C"),
	DIAMONDS("D"),
	SPADES("S");
	
	private final String symbol;
}