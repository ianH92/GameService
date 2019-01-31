package gameservice.game.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import gameservice.game.constants.Card;
import gameservice.game.gameexceptions.DeckEmptyException;

/**
 * Test class for StandardDeck
 * 
 * @author ianH92
 *
 */
public class StandardDeckTest {
	private List<Card> cards;
	
	public StandardDeckTest() {
		cards = Arrays.asList(Card.values());
	}
	
	/**
	 * Test that the getDeck method returns a set of 52 unique cards
	 */
	@Test
	public void getDeckTest() {
		Set<Card> deckCards = new HashSet<>(new StandardDeck().getDeck());
		Set<Card> cardValues = new HashSet<>(cards);
		assertEquals(cardValues, deckCards);
	}
	
	/**
	 * Test size method for StandardDeck
	 */
	@Test
	public void getSizeTest() {
		assertEquals(52, new StandardDeck().size());
	}
	
	/**
	 * Test nextCard method returns all 52 cards
	 * 
	 * @throws DeckEmptyException
	 */
	@Test
	public void nextCardTest() throws DeckEmptyException {
		StandardDeck deck = new StandardDeck();
		for(int i = 0; i < 52; i++) {
			Card card = deck.nextCard();
			assertTrue(cards.contains(card));
		}
	}
	
	/**
	 * Test that nextCard throws a DeckEmptyException after retrieving 52 cards
	 * 
	 * @throws DeckEmptyException
	 */
	@Test(expected = DeckEmptyException.class)
	public void nextCardThrowsExceptionTest() throws DeckEmptyException {
		StandardDeck deck = new StandardDeck();
		for(int i = 0; i <= 52; i++) {
			@SuppressWarnings("unused")
			Card card = deck.nextCard();
		}
	}
}
