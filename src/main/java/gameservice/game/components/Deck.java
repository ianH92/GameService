package gameservice.game.components;

import java.util.List;

import gameservice.game.constants.Card;
import gameservice.game.gameexceptions.DeckEmptyException;

public interface Deck {
	public List<Card> getDeck();
	public int size();
	public Card nextCard() throws DeckEmptyException;
}
