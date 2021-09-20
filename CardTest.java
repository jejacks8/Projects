import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//TODO: Add documentation to pass checkstyle

/**
 * Tests Card class
 * 
 * @author Jessica Young Schmidt
 * @author Joseph Jackson 
 */
public class CardTest {

    /** three of clubs */
    private Card c3;
	private Card h4;
	private Card d12;
	private Card c8;

    /**
     * Sets up fields for testing
     */
    @BeforeEach
    public void setUp() {
        c3 = new Card('c', 3);
		h4 = new Card('h', 4);
		d12 = new Card('d', 12);
		c8 = new Card('c',8);
    }

    /**
     * Test invalid constructor parameters
     */
    @Test
    public void testInvalidConstructorParameters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Card('a', 33),
                "invalid suit");
        assertEquals("Invalid suit", exception.getMessage(), "invalid suit - exception message");

        exception = assertThrows(IllegalArgumentException.class, () -> new Card('c', 1),
                "invalid value (1)");
        assertEquals("Invalid value", exception.getMessage(),
                "invalid value (1) - exception message");

        // NOTE: You are not required to add additional invalid parameter test. However,
        // you may add tests if you would like. Not all paths through your Card
        // constructors will be tested by the given tests above.
    }

    /**
     * Test getSuit for three of clubs
     */
    @Test
    public void testGetSuitA() {
        assertEquals('c', c3.getSuit(), "Test getSuit for three of clubs");
    }

    @Test
    public void testGetSuitB() {
        assertEquals('d', d12.getSuit(), "Test getSuit for Queen of Diamonds");// TODO: Write additional test for getSuit
    }

    /**
     * Test getValue for three of clubs
     */
    @Test
    public void testGetValueA() {
        assertEquals(3, c3.getValue(), "Test getValue for three of clubs");
    }

    @Test
    public void testGetValueB() {
        assertEquals(12, d12.getValue(), "Test getValue for Queen of Diamonds"); // TODO: Write additional test for getValue
    }

    /**
     * Test hasBeenPlayed for three of clubs
     */
    @Test
    public void testHasBeenPlayed() {
        assertFalse(c3.hasBeenPlayed(), "Test hasBeenPlayed for three of clubs");
    }

    @Test
    public void testSetPlayed() {
		c3.setPlayed(false);
		
        assertEquals(false, c3.hasBeenPlayed(), "Test setPlayed for not been played three of clubs");// TODO: Write test for setPlayed method
    }

    /**
     * Test isHeart for three of clubs
     */
    @Test
    public void testIsHeartA() {
        assertFalse(c3.isHeart(), "Test isHeart for three of clubs");
    }

    @Test
    public void testIsHeartB() {
        assertTrue(h4.isHeart(), "Test isHeart for four of hearts"); // TODO: Write test for isHeart that would return true
    }

    /**
     * Test toString for three of clubs
     */
    @Test
    public void testToStringA() {
        assertEquals("c3", c3.toString(), "Test toString for three of clubs");
    }

    @Test
    public void testToStringB() {
        assertEquals("d12", d12.toString(), "Test toString for Queen of Diamonds");// TODO: Write additional test for toString
    }

    /**
     * Test equals for three of clubs
     */
    @Test
    public void testEqualsA() {
        assertTrue(c3.equals(c3), "Test equals for three of clubs");
    }

    @Test
    public void testEqualsB() {
        assertFalse(c3.equals(d12), "Test equals for four of diamonds and three of clubs");// TODO: Write test for equals that would return false - cards with different
        // suits
    }

    @Test
    public void testEqualsC() {
        assertFalse(c3.equals(c8), "Test equals for three of clubs and eight of clubs");// TODO: Write test for equals that would return false - cards with same suit
        // but different values
    }

    @Test
    public void testEqualsD() {
		Card notPlayedc3 = new Card('c',3);
		notPlayedc3.setPlayed(false);
		c3.setPlayed(true);
        assertFalse(c3.equals(notPlayedc3), "Test equals for three of clubs and three of clubs that has not been played yet");// TODO: Write test for equals that would return false - cards with same suit
        // and same value but different hasBeenPlayed
    }

    /**
     * Test compareTo for three of clubs and three of spades
     */
    @Test
    public void testCompareToA() {
        Card s3 = new Card('s', 3);
        assertTrue(c3.compareTo(s3) < 0, "Test compareTo for three of clubs and three of spades");
    }

    @Test
    public void testCompareToB() {
		assertTrue(c8.compareTo(c3) > 0, "Test compareTo for four of clubs and three of clubs");// TODO: Write compareTo test that would return positive integer with two cards
        // of the same suit
    }

    @Test
    public void testCompareToC() {
        assertTrue(d12.compareTo(c3) > 0, "Test compareTo for Queen of Diamonds and three of clubs");// TODO: Write compareTo test that would return positive integer with two cards
        // of different suits
    }

    @Test
    public void testCompareToD() {
        assertTrue(c3.compareTo(c8) < 0, "Test compareTo for three of clubs and eight of clubs");// TODO: Write compareTo test that would return negative integer with two cards
        // of the same suit
    }

    @Test
    public void testCompareToE() {
        assertTrue(c3.compareTo(c3) == 0, "Test compareTo for three of clubs and three of clubs");// TODO: Write compareTo test that would return 0
    }

    /**
     * Test isQueenOfSpades for three of clubs
     */
    @Test
    public void testIsQueenOfSpadesA() {
        assertFalse(c3.isQueenOfSpades(), "Test isQueenOfSpades for three of clubs");

    }

    @Test
    public void testIsQueenOfSpadesB() {
		Card s12 = new Card('s', 12);
        assertTrue(s12.isQueenOfSpades(), "Test isQueenOfSpades for queen of spades");// TODO: Write test for isQueenOfSpades that would return true
    }

    @Test
    public void testIsQueenOfSpadesC() {
		Card s3 = new Card('s',3);
        assertFalse(s3.isQueenOfSpades(), "Test isQueenOfSpades for three of spades");// TODO: Write test for isQueenOfSpades that would return false but is spades
    }

    /**
     * Test isHigherThan for four of clubs and three of clubs
     */
    @Test
    public void testIsHigherA() {
        Card c4 = new Card('c', 4);
        assertTrue(c4.isHigherThan(c3), "Test isHigherThan for four of clubs and three of clubs");
    }

    @Test
    public void testIsHigherB() {
        assertFalse(c3.isHigherThan(d12), "Test isHigherThan for three of clubs and queen of diamonds");// TODO: Write test for isHigherThan that returns false with different suits
    }

    @Test
    public void testIsHigherC() {
        assertFalse(c3.isHigherThan(c8), "Test isHigherThan for three of clubs and eight of clubs");// TODO: Write test for isHigherThan that returns false with same suit
    }

    /**
     * Tests values for public constants
     */
    @Test
    public void testClassConstants() {
        assertEquals('c', Card.CLUBS, "Test CLUBS constant");
        assertEquals('d', Card.DIAMONDS, "Test DIAMONDS constant");
        assertEquals('s', Card.SPADES, "Test SPADES constant");
        assertEquals('h', Card.HEARTS, "Test HEARTS constant");
        assertEquals(2, Card.LOWEST_VALUE, "Test LOWEST_VALUE constant");
        assertEquals(14, Card.HIGHEST_VALUE, "Test HIGHEST_VALUE constant");
        assertEquals(12, Card.QUEEN_VALUE, "Test QUEEN_VALUE constant");
    }

}