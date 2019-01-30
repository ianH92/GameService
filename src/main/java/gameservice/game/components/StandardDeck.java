package gameservice.game.components;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import gameservice.game.constants.Card;
import gameservice.game.gameexceptions.DeckEmptyException;

/**
 * Implementation of a standard 52-card deck. The deck is randomly shuffled at instantiation
 * 
 * @author ianH92
 */
public class StandardDeck implements Deck {
	private Card[] deck;
	private int currentCard;
	
	/**
	 * Create a randomly shuffled deck consisting of the 52 standard cards
	 */
	public StandardDeck() {
		Random random = new Random();
		Card[] cards = Card.values();
		
		for(int i = (cards.length - 1); i > 0; i--) {
			int index = random.nextInt(i);
			Card card = cards[index];
			cards[index] = cards[i];
			cards[i] = card;
		}
		
		deck = cards;
		currentCard = 0;
	}

	/**
	 * Return a list representation of the deck
	 * @return the randomly shuffled deck of 52 cards
	 */
	@Override
	public List<Card> getDeck() {
		return Arrays.asList(deck);
	}

	/**
	 * Returns the number of cards in the deck
	 * @return the deck size
	 */
	@Override
	public int size() {
		return deck.length;
	}

	/**
	 * Returns the next card in the deck. Throws an error if the number of calls to the method
	 * has exceeded the number of cards
	 * 
	 * @throws DeckEmptyException if the number of calls to the method exceed the card count
	 * @return the next card in the deck
	 */
	@Override
	public Card nextCard() throws DeckEmptyException {
		if(currentCard >= deck.length) throw new DeckEmptyException("Deck length exceeded");
		
		Card card = deck[currentCard++];
		return card;
	}

}
