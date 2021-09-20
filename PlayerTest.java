import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//TODO: Add documentation to pass checkstyle

/**
 * Tests Player class
 * 
 * @author Jessica Young Schmidt
 * @author Joseph Jackson 
 */
public class PlayerTest {

    /** Test player */
    private Player testPlayer;

    /** Three of clubs */
    private Card c3;
	private Card c4;

    /**
     * Set up fields for tests
     */
    @BeforeEach
    public void setUp() {
        testPlayer = new Player("Human");
        c3 = new Card('c', 3);
		c4 = new Card('c', 4);
    }

    @Test
    public void testConstructor() {
        assertEquals("Human", testPlayer.getName(), "Test constructor: getName");
        for (int i = 0; i < 13; i++) {
            assertNull(testPlayer.getCard(i), "Test that card " + i + " is null");
        }
        assertEquals(0, testPlayer.getHandPoints(), "Test constructor: getHandPoints");
        assertEquals(0, testPlayer.getOverallPoints(), "Test constructor: getOverallPoints");
    }

    @Test
    public void testAddCardA() {
        // Test that there are no cards in hand
        String id = "test that first card of hand is null";
        assertNull(testPlayer.getCard(0), id);

        // Add a card to the hand
        testPlayer.addCard(c3);
        id = "test that card is added as first card";
        assertEquals(new Card('c', 3), testPlayer.getCard(0), id);
        for (int i = 1; i < 13; i++) {
            assertNull(testPlayer.getCard(i), "Test that card " + i + " is null");
        }
    }

    @Test
    public void testAddCardB() {
        String id = "test that first card of hand is null";
        assertNull(testPlayer.getCard(0), id);

        // Add a card to the hand
        testPlayer.addCard(c3);
        id = "test that card is added as first card";
        assertEquals(new Card('c', 3), testPlayer.getCard(0), id);
        for (int i = 1; i < 13; i++) {
            assertNull(testPlayer.getCard(i), "Test that card " + i + " is null");
        }// TODO write test case for adding multiple cards
		testPlayer.addCard(c4);
        id = "test that card is added as second card";
        assertEquals(new Card('c', 4), testPlayer.getCard(1), id);
        for (int i = 2; i < 13; i++) {
            assertNull(testPlayer.getCard(i), "Test that card " + i + " is null");
		}
    }

    @Test
    public void testGetCardException() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> testPlayer.getCard(-1), "Invalid index");
        assertEquals("Invalid index", exception.getMessage(), "Invalid index - exception message");
    }

    @Test
    public void testHasActiveCardOfSuitException() {
        Exception exception = assertThrows(IllegalStateException.class,
            () -> testPlayer.hasActiveCardOfSuit('c'), "Hand not full");
        assertEquals("Hand not full", exception.getMessage(), "Hand not full - exception message");
    }

    @Test
    public void testOnlyHasHeartsException() {
        Exception exception = assertThrows(IllegalStateException.class,
            () -> testPlayer.onlyHasHearts(), "Hand not full");
        assertEquals("Hand not full", exception.getMessage(), "Hand not full - exception message");
    }

    @Test
    public void testGetCardNamesException() {
        Exception exception = assertThrows(IllegalStateException.class,
            () -> testPlayer.getCardNames(), "Hand not full");
        assertEquals("Hand not full", exception.getMessage(), "Hand not full - exception message");
    }

    @Test
    public void testHasActiveCardOfSuitA() {
		for( int i = 0; i < 13; i++){
			testPlayer.addCard(c3);
		}
		c3.setPlayed(true);
        assertTrue(testPlayer.hasActiveCardOfSuit('c'), "Test if hand has card of suit clubs");// TODO: write test of hasActiveCardOfSuit that results in true
    }

    @Test
    public void testHasActiveCardOfSuitB() {
		Card h2 = new Card('h',2);
		Card h3 = new Card('h',3);
		Card h4 = new Card('h',4);
		Card h5 = new Card('h',5);
		Card h6 = new Card('h',6);
		Card h7 = new Card('h',7);
		Card h8 = new Card('h',8);
		Card h9 = new Card('h',9);
		Card h10 = new Card('h',10);
		Card h11 = new Card('h',11);
		Card h12 = new Card('h',12);
		Card h13 = new Card('h',13);
		
		testPlayer.addCard(c3);
		testPlayer.addCard(h2);
		testPlayer.addCard(h3);
		testPlayer.addCard(h4);
		testPlayer.addCard(h5);
		testPlayer.addCard(h6);
		testPlayer.addCard(h7);
		testPlayer.addCard(h8);
		testPlayer.addCard(h9);
		testPlayer.addCard(h10);
		testPlayer.addCard(h11);
		testPlayer.addCard(h12);
		testPlayer.addCard(h13);
		
		c3.setPlayed(false);
        assertFalse(testPlayer.hasActiveCardOfSuit('s'), "Test if hand has spades, false");// TODO: write test of hasActiveCardOfSuit that results in false
    }

    @Test
    public void testOnlyHasHeartsA() {
		Card h2 = new Card('h',2);
		Card h3 = new Card('h',3);
		Card h4 = new Card('h',4);
		Card h5 = new Card('h',5);
		Card h6 = new Card('h',6);
		Card h7 = new Card('h',7);
		Card h8 = new Card('h',8);
		Card h9 = new Card('h',9);
		Card h10 = new Card('h',10);
		Card h11 = new Card('h',11);
		Card h12 = new Card('h',12);
		Card h13 = new Card('h',13);
		Card h14 = new Card('h',14);
		
		testPlayer.addCard(h2);
		testPlayer.addCard(h3);
		testPlayer.addCard(h4);
		testPlayer.addCard(h5);
		testPlayer.addCard(h6);
		testPlayer.addCard(h7);
		testPlayer.addCard(h8);
		testPlayer.addCard(h9);
		testPlayer.addCard(h10);
		testPlayer.addCard(h11);
		testPlayer.addCard(h12);
		testPlayer.addCard(h13);
		testPlayer.addCard(h14);
        assertTrue(testPlayer.onlyHasHearts(), "Test onlyHasHearts for true");// TODO: write test of onlyHasHearts that results in true
    }

    @Test
    public void testOnlyHasHeartsB() {
       Card h2 = new Card('h',2);
		Card h3 = new Card('h',3);
		Card h4 = new Card('h',4);
		Card h5 = new Card('h',5);
		Card h6 = new Card('h',6);
		Card h7 = new Card('h',7);
		Card h8 = new Card('h',8);
		Card h9 = new Card('h',9);
		Card h10 = new Card('h',10);
		Card h11 = new Card('h',11);
		Card h12 = new Card('h',12);
		Card h13 = new Card('h',13);
		Card h14 = new Card('h',14);
		
		testPlayer.addCard(h2);
		testPlayer.addCard(c3);
		testPlayer.addCard(h4);
		testPlayer.addCard(h5);
		testPlayer.addCard(h6);
		testPlayer.addCard(h7);
		testPlayer.addCard(h8);
		testPlayer.addCard(h9);
		testPlayer.addCard(h10);
		testPlayer.addCard(h11);
		testPlayer.addCard(h12);
		testPlayer.addCard(h13);
		testPlayer.addCard(h14);
        assertFalse(testPlayer.onlyHasHearts(), "Test onlyHasHearts for false");// TODO: write test of onlyHasHearts that results in false
    }

    @Test
    public void testGetCardNames() {
        Card h2 = new Card('h',2);
		Card h3 = new Card('h',3);
		Card h4 = new Card('h',4);
		Card h5 = new Card('h',5);
		Card h6 = new Card('h',6);
		Card h7 = new Card('h',7);
		Card h8 = new Card('h',8);
		Card h9 = new Card('h',9);
		Card h10 = new Card('h',10);
		Card h11 = new Card('h',11);
		Card h12 = new Card('h',12);
		Card h13 = new Card('h',13);
		Card h14 = new Card('h',14);
		
		testPlayer.addCard(h2);
		testPlayer.addCard(c3);
		testPlayer.addCard(h4);
		testPlayer.addCard(h5);
		testPlayer.addCard(h6);
		testPlayer.addCard(h7);
		testPlayer.addCard(h8);
		testPlayer.addCard(h9);
		testPlayer.addCard(h10);
		testPlayer.addCard(h11);
		testPlayer.addCard(h12);
		testPlayer.addCard(h13);
		testPlayer.addCard(h14);
		Card[] expected = new Card[13];
		expected[0] = c3;
		expected[1] = h2;
		expected[2] = h4;
		expected[3] = h5;
		expected[4] = h6;
		expected[5] = h7;
		expected[6] = h8;
		expected[7] = h9;
		expected[8] = h10;
		expected[9] = h11;
		expected[10] = h12;
		expected[11] = h13;
		expected[12] = h14;
		String expectedStr = Arrays.toString(expected);
		String testString = Arrays.toString(testPlayer.getCardNames());
		assertEquals(expectedStr, testString, "Test getCardNames");// TODO: write test of getCardNames
    }

    /**
     * Tests toString
     */
    @Test
    public void testToString() {
        assertEquals("Human: 0", testPlayer.toString(), "Test toString");
    }

    @Test
    public void testToStringNonZeroPoints() {
		testPlayer.addToHandPoints(10);
        assertEquals("Human: 10", testPlayer.toString(), "Test toStirng for non zero point value");// TODO: Add test for toString for non-zero points
    }

    @Test
    public void testAddToHandPoints() {
		testPlayer.addToHandPoints(10);
        assertEquals(10, testPlayer.getHandPoints(), "Test add hand points for 10 points");// TODO: Add test for addToHandPoints
    }

    @Test
    public void testResetHandPoints() {
		testPlayer.resetHandPoints();
        assertEquals(0, testPlayer.getHandPoints(), "Test reset hand points, check for zero points");// TODO: Add test for resetHandPoints
    }

    @Test
    public void testDumpCards() {
		testPlayer.dumpCards();
        assertEquals(null, testPlayer.getCard(1), "Test dumpcards, check if the cards are null");// TODO: Write test for dumpCards
    }

    /**
     * Test getMove method
     */
    @Test
    public void testGetMove() {

        Card c2 = new Card('c', 2);
        Card c12 = new Card('c', 12);
        Card d4 = new Card('d', 4);
        Card d5 = new Card('d', 5);
        Card d7 = new Card('d', 7);
        Card d12 = new Card('d', 12);
        Card s5 = new Card('s', 5);
        Card s11 = new Card('s', 11);
        Card s12 = new Card('s', 12);
        Card h2 = new Card('h', 2);
        Card h3 = new Card('h', 3);
        Card h5 = new Card('h', 5);

        testPlayer.addCard(c3);
        testPlayer.addCard(h5);
        testPlayer.addCard(d7);
        testPlayer.addCard(s12);
        testPlayer.addCard(c12);
        testPlayer.addCard(c2);
        testPlayer.addCard(d4);
        testPlayer.addCard(h2);
        testPlayer.addCard(s5);
        testPlayer.addCard(s11);
        testPlayer.addCard(d5);
        testPlayer.addCard(h3);
        testPlayer.addCard(d12);

        // Test first round (trick) and the computer player has the 2 of Clubs
        Card c2Copy = new Card('c', 2);
        c2Copy.setPlayed(true);
        assertEquals(c2Copy, testPlayer.getMove(null, true, false), "Has 2 of clubs");
        Card c3copy = new Card('c', 3);
        c3copy.setPlayed(true);
        assertEquals(c3copy, testPlayer.getMove(new Card('c', 4), true, false), "Lowest clubs");
    }
}