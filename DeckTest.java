import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//TODO: Add documentation to pass checkstyle

/**
 * Tests Deck class
 * 
 * @author Jessica Young Schmidt
 * @author
 */
public class DeckTest {

    /** Deck for testing */
    private Deck deck;

    /**
     * Sets up fields for testing
     */
    @BeforeEach
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void testConstructor() {
		Card cards[] = deck.getCards();
		Card expectedCards[] = {new Card(Card.CLUBS, 2), new Card(Card.CLUBS, 3), new Card(Card.CLUBS, 4), new Card(Card.CLUBS, 5), new Card(Card.CLUBS, 6), new Card(Card.CLUBS, 7), new Card(Card.CLUBS, 8), new Card(Card.CLUBS, 9), new Card(Card.CLUBS, 10), new Card(Card.CLUBS, 11), new Card(Card.CLUBS, 12), new Card(Card.CLUBS, 13), new Card(Card.CLUBS, 14),
		 new Card(Card.DIAMONDS, 2), new Card(Card.DIAMONDS, 3), new Card(Card.DIAMONDS, 4), new Card(Card.DIAMONDS, 5), new Card(Card.DIAMONDS, 6), new Card(Card.DIAMONDS, 7), new Card(Card.DIAMONDS, 8), new Card(Card.DIAMONDS, 9), new Card(Card.DIAMONDS, 10), new Card(Card.DIAMONDS, 11), new Card(Card.DIAMONDS, 12), new Card(Card.DIAMONDS, 13), new Card(Card.DIAMONDS, 14),
		 new Card(Card.SPADES, 2), new Card(Card.SPADES, 3), new Card(Card.SPADES, 4), new Card(Card.SPADES, 5), new Card(Card.SPADES, 6), new Card(Card.SPADES, 7), new Card(Card.SPADES, 8), new Card(Card.SPADES, 9), new Card(Card.SPADES, 10), new Card(Card.SPADES, 11), new Card(Card.SPADES, 12), new Card(Card.SPADES, 13), new Card(Card.SPADES, 14),
		 new Card(Card.HEARTS, 2), new Card(Card.HEARTS, 3), new Card(Card.HEARTS, 4), new Card(Card.HEARTS, 5), new Card(Card.HEARTS, 6), new Card(Card.HEARTS, 7), new Card(Card.HEARTS, 8), new Card(Card.HEARTS, 9), new Card(Card.HEARTS, 10), new Card(Card.HEARTS, 11), new Card(Card.HEARTS, 12), new Card(Card.HEARTS, 13), new Card(Card.HEARTS, 14),
		};
			assertTrue(Arrays.equals(cards,expectedCards), "Test constructor for actual vs expected array values");
        // TODO Write test to check cards array must be created in this order (Clubs
        // 2-14, Diamonds 2-14, Spades 2-14, Hearts 2-14), that is, the Card at index 0
        // must be the 2 of Clubs, the Card at index 1 must be the 3 of Clubs, â€¦, and
        // the card at index 51 must be the Ace (14) of Hearts
    }

    /**
     * Test nextCard for the first card
     */
    @Test
    public void testNextCardA() {
        assertEquals(new Card('c', 2), deck.nextCard(), "Test first card");
    }

    @Test
    public void testNextCardB() {
		deck.nextCard();
        assertEquals(new Card('c', 3), deck.nextCard(), "Test second card");// TODO: Add test for nextCard
    }

    /**
     * Tests that exception is thrown for next card when no cards are left
     */
    @Test
    public void testNextCardException() {
        for (int i = 0; i < 52; i++) {
            deck.nextCard();
        }

        Exception exception = assertThrows(IllegalStateException.class, () -> deck.nextCard(),
                "no cards left");
        assertEquals("No more cards", exception.getMessage(), "No more cards - exception message");
    }

    @Test
    public void testGetNext() {
        assertEquals(0, deck.getNext(), "Test for next card starting at position zero");// TODO: Write test for getNext method
    }

    @Test
    public void testGetCards() {
       Card cards[] = deck.getCards();
	   Card expectedCards[] = {new Card(Card.CLUBS, 2), new Card(Card.CLUBS, 3), new Card(Card.CLUBS, 4), new Card(Card.CLUBS, 5), new Card(Card.CLUBS, 6), new Card(Card.CLUBS, 7), new Card(Card.CLUBS, 8), new Card(Card.CLUBS, 9), new Card(Card.CLUBS, 10), new Card(Card.CLUBS, 11), new Card(Card.CLUBS, 12), new Card(Card.CLUBS, 13), new Card(Card.CLUBS, 14),
		 new Card(Card.DIAMONDS, 2), new Card(Card.DIAMONDS, 3), new Card(Card.DIAMONDS, 4), new Card(Card.DIAMONDS, 5), new Card(Card.DIAMONDS, 6), new Card(Card.DIAMONDS, 7), new Card(Card.DIAMONDS, 8), new Card(Card.DIAMONDS, 9), new Card(Card.DIAMONDS, 10), new Card(Card.DIAMONDS, 11), new Card(Card.DIAMONDS, 12), new Card(Card.DIAMONDS, 13), new Card(Card.DIAMONDS, 14),
		 new Card(Card.SPADES, 2), new Card(Card.SPADES, 3), new Card(Card.SPADES, 4), new Card(Card.SPADES, 5), new Card(Card.SPADES, 6), new Card(Card.SPADES, 7), new Card(Card.SPADES, 8), new Card(Card.SPADES, 9), new Card(Card.SPADES, 10), new Card(Card.SPADES, 11), new Card(Card.SPADES, 12), new Card(Card.SPADES, 13), new Card(Card.SPADES, 14),
		 new Card(Card.HEARTS, 2), new Card(Card.HEARTS, 3), new Card(Card.HEARTS, 4), new Card(Card.HEARTS, 5), new Card(Card.HEARTS, 6), new Card(Card.HEARTS, 7), new Card(Card.HEARTS, 8), new Card(Card.HEARTS, 9), new Card(Card.HEARTS, 10), new Card(Card.HEARTS, 11), new Card(Card.HEARTS, 12), new Card(Card.HEARTS, 13), new Card(Card.HEARTS, 14),
		};
		assertTrue(Arrays.equals(cards, expectedCards), "Test getcards method by comparing actual and expected array.");
    }

    /**
     * Test toString
     */
    @Test
    public void testToString() {
        String expected = "card 0: c2\n" + "card 1: c3\n" + "card 2: c4\n" + "card 3: c5\n"
                + "card 4: c6\n" + "card 5: c7\n" + "card 6: c8\n" + "card 7: c9\n"
                + "card 8: c10\n" + "card 9: c11\n" + "card 10: c12\n" + "card 11: c13\n"
                + "card 12: c14\n" + "card 13: d2\n" + "card 14: d3\n" + "card 15: d4\n"
                + "card 16: d5\n" + "card 17: d6\n" + "card 18: d7\n" + "card 19: d8\n"
                + "card 20: d9\n" + "card 21: d10\n" + "card 22: d11\n" + "card 23: d12\n"
                + "card 24: d13\n" + "card 25: d14\n" + "card 26: s2\n" + "card 27: s3\n"
                + "card 28: s4\n" + "card 29: s5\n" + "card 30: s6\n" + "card 31: s7\n"
                + "card 32: s8\n" + "card 33: s9\n" + "card 34: s10\n" + "card 35: s11\n"
                + "card 36: s12\n" + "card 37: s13\n" + "card 38: s14\n" + "card 39: h2\n"
                + "card 40: h3\n" + "card 41: h4\n" + "card 42: h5\n" + "card 43: h6\n"
                + "card 44: h7\n" + "card 45: h8\n" + "card 46: h9\n" + "card 47: h10\n"
                + "card 48: h11\n" + "card 49: h12\n" + "card 50: h13\n" + "card 51: h14\n";
        assertEquals(expected, deck.toString(), "Test toString after constructing deck");
    }

    /**
     * Test initialize method
     */
    @Test
    public void testInitialize() {
        Deck deck2 = new Deck();
        assertTrue(deck.equals(deck2), "Test that the decks are equal after constructor");
        deck2.nextCard();
        assertFalse(deck.equals(deck2), "Test that not equal if call nextCard on one");
        deck2.initialize();
        assertTrue(deck.equals(deck2), "Test that equal after initialize called");

    }

    /**
     * Test that shuffle results in different deck
     */
    @Test
    public void testShuffle() {
        Deck deck2 = new Deck();
        deck2.shuffle();
        assertFalse(deck.equals(deck2), "Test that shuffle results in different deck");
    }

    /**
     * Test equal decks
     */
    @Test
    public void testEqualsA() {
        Deck deck2 = new Deck();
        assertTrue(deck.equals(deck2), "Test equal decks");
    }

    @Test
    public void testEqualsB() {
        Deck deck3 = new Deck();
		deck3.shuffle();
		assertFalse(deck.equals(deck3), "Test equals for unequal decks.");// TODO: Add test for unequal decks
    }

    /**
     * Tests values for public constant
     */
    @Test
    public void testClassConstants() {
        assertEquals(52, Deck.CARDS_IN_DECK, "Test CARDS_IN_DECK constant");
    }
}