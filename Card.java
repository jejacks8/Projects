public class Card implements Comparable<Card>{
	 
	 //public class constants 
	 public static final char CLUBS = 'c'; //character value for clubs 
	 public static final char DIAMONDS = 'd';  //character value for diamonds 
	 public static final char HEARTS = 'h';   //character value for hearts 
	 public static final char SPADES = 's';   //chracter value for spades 
	 public static final int LOWEST_VALUE = 2; //integer value of the least value of the card
	 public static final int HIGHEST_VALUE = 14;  //integer value of the highest value card 
	 public static final int QUEEN_VALUE = 12;    //the value of the queen card 
	 //instance fields 
	 private char suit;     //knows the charcter that represents the suit of the card 
	 private int value;    //knows the integer value that represents placement of card in array 
	 private boolean hasBeenPlayed;   //knows if card has been played or not 
	 
	 /**
	 * this method is a contructor of Object Card 
	 * @param chracter suit, knows the character corresponding to th suit of the card
	 * @param integer value, knows the integer value and therefore place of the card, facecards are 11,12,13 and aces are 14
	 * @throws IllegalArgumentException if the character suit is not a character that represents a provided suit 
	 * @throws IllegalArgumentException if the value is less than 2, the first card value or higher than 14, the last card value 
	 */
	 public Card(char suit, int value){
		if(suit != CLUBS && suit != DIAMONDS && suit != HEARTS && suit != SPADES){
			throw new IllegalArgumentException("Invalid suit");
		}
		if(value < LOWEST_VALUE || value > HIGHEST_VALUE){
			throw new IllegalArgumentException("Invalid value");
		}
		this.suit = suit;
		this.value = value;
	 }
	 /**
	 * this method simply returns the instance field suit 
	 * @return character instance field suit, knows character that represents the suit of card
	 */
	 public char getSuit(){
		 return suit;
	 }
	 /**
	 * this method simply returns the instance field value 
	 * @return integer instance field value, knows the integer value of the card 
	 */
	 public int getValue(){
		 return value;
	 }
	 /**
	 * this method simply returns the instance field hasBeenPlayed
	 * @return boolean instance field hasBeenPlayed, knows whether or not the card has been played
	 */
	 public boolean hasBeenPlayed(){
		 return hasBeenPlayed;
	 }
	 /**
	 * this method sets the status of the card to the given parameter of hasBeenPlayed
	 * @param boolean played, knows wheter the card has been played or not T/FREE_MEM
	 * if the parameter played is true, sets the cards hasBeenPlayed to true, otherwise hasBeenPlayed is false 
	 */
	 public void setPlayed(boolean played){
		 if(played){
			 hasBeenPlayed = true;
		 }
	 }
	 /**
	 * this method true false based on if the card includes the character that represents the suit heart 
	 * @return true if the suit is hearts 
	 * @return false if otherwise 
	 */
	 public boolean isHeart(){
		 return suit == HEARTS;
	 }
	 /**
	 * this method returns true false based on if the card is the queen of spades 
	* @return true if the card is the queen of spades, has the same character value of spades and integer value of queen 
	* @return false if otherwise 
	*/
	 public boolean isQueenOfSpades(){
		 return (suit == SPADES && value == QUEEN_VALUE);
	 }
	 /**
	 * determines if the one card is higher than the other, returns true false 
	 * @param Card other, knows the card that is been compared to this card 
	 * @return true if the instance of this class suit is the same and the value is higher, based on the position the card is in the array 
	 * @return false if otherwise 
	 */
	 public boolean isHigherThan(Card other){
		 return suit == other.suit && value > other.value;
	 }
	 /**
	 * this method returns true or false based on if the parameter o, a card object, is an instance of this card object and suit, integer value and hasBeenPlayed value are equal 
	 * @return true if meets all requirements, equal suit, equal integer value, and hasBeenPlayed are equal 
	 * @return false if just one does not meet requirements 
	 */
	 public boolean equals(Object o){
		 if( o instanceof Card){
			 Card other = (Card) o;
			 return suit == other.getSuit()
					&& value == other.getValue()
					&& hasBeenPlayed == other.hasBeenPlayed();
		 }
		 return false;
	 }
	 /**
	 * this method creates a string that includes the suit character and the integer value 
	 * @return a String "" and suit character and then value such as c3
	 */
	 public String toString(){
		 return "" + suit + value;
	 }
	 /**
     * This method is used for sorting cards.
     * It orders the cards by suit (Clubs, Diamonds, Spades, Hearts) and then by
     * value within the suit
     * @param o The Card object to which this Card is being compared.
     * @return  negative value if this Card should be before the other Card,
     *          positive value if this Card should be after the other Card,
     *          0 if this Card has the same suit and value as the other Card.
     */
    public int compareTo(Card other) {
        if (getSuit() == other.getSuit()) {
            if (getValue() < other.getValue()) {
                return -1;
            } else if (getValue() > other.getValue()) {
                return 1;
            }
            else {
                return 0;
            }
        } 
        else {
            switch(getSuit()) {
                case HEARTS:
                    return 1;
                case SPADES:
                    if (other.getSuit() == HEARTS) {
                        return -1;
                    } 
                    else {
                        return 1;
                    }
                case DIAMONDS:
                    if (other.getSuit() == HEARTS || other.getSuit() == SPADES) {
                        return -1;
                    } 
                    else {
                        return 1;
                    }
                //CLUBS
                default:
                    return -1;
            }
        }
    }
}