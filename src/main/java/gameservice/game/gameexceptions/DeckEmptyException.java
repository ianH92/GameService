package gameservice.game.gameexceptions;

/**
 * Exception class for attempting to draw from an empty deck
 * 
 * @author ianH92
 *
 */
@SuppressWarnings("serial")
public class DeckEmptyException extends Exception {
	public DeckEmptyException(String message) {
		super(message);
	}
}
