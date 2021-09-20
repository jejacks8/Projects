import java.lang.*;
import java.util.*;
public class Deck{
	//class constant 
	public static final int CARDS_IN_DECK = 52;
	
	//instance fields 
	private Card[] cards;   //Card array cards, includes the Deck as each card of object Card
	private int next;       //integer next that knows the integer value of the next card in the array 
	
	/** 
	* this method is the contructor for the deck class
	* creates a Card array and fills each element with a new Card in order of clubs, diamonds, spades and then hearts in numerical order 
	* sets the instance field that knows the next card to 0
	*/
	public Deck(){
		cards = new Card[CARDS_IN_DECK];
		for(int i = 0; i < CARDS_IN_DECK; i++) {
			//fills in the clubs c2-c14
			if(i >= 0 && i <=12) {
			cards[i] = new Card(Card.CLUBS, (i + Card.LOWEST_VALUE));
			}
			//fills in the diamonds d2-d14
			else if(i > 12 && i <=25) {
			cards[i] = new Card(Card.DIAMONDS, (i - 11));
			}
			//fills in the spades s2-s14
			else if(i > 25 && i <= 38) {
			cards[i] = new Card(Card.SPADES, (i - 24));
			}
			//fills in the hearts h2-h14
			else if(i < CARDS_IN_DECK){
			cards[i] = new Card(Card.HEARTS, (i - 37));
			}
		}
		next = 0;
	}
	/** 
	* simply returns the instance field next 
	* @return next, integer instance field that knows which card is next 
	*/
	public int getNext(){
		return next;
	}
	/**
	* simply returns the instance field of Card array cards 
	* @return cards, object Card array that contains the card objects in the deck 
	*/
	public Card[] getCards(){
		return cards;
	}
	/**
	* this method shuffles the cards randomly in the deck
	* creates random object and calculates random number from 0-cards length
	* uses foor loop and temporary subsitiution to create a swap and respeats for every card
	*/
	public void shuffle(){
		Random rand = new Random();
		int n = cards.length;
		for(int i = n - 1; i >= 1; i--){
			int randElement = rand.nextInt(n);
			int temp = i;
			cards[i] = cards[randElement];
			cards[randElement] = cards[temp];
		}
	}
	/** 
	* this method trunicates through cards array and changes each hasBeenPlayedYet to false so that each element/card in the array is ready to be played 
	* resets instance field next to 0 
	*/
	public void initialize(){
		for(int i = 0; i < cards.length; i++){
			if(cards[i] != null){
				
				cards[i].setPlayed(false);
			}
		}
		next = 0;
	}
	/**
	* this method returns the card in the index known by the instance field next 
	* @throws IllegalStateException with message "No more cards" if the instance field next is past the number 52 and therefore no more cards are in the deck array 
	* @return Card array card with integer at the index of integer instance field next, returns the next card in the Deck array 
	* increments instance field next by one each time method is called 
	*/
	public Card nextCard(){
		if( next >= 52){
			throw new IllegalStateException ("No more cards"); //throws IllegalStateException
		}
		int nextCard;
		nextCard = next;
		next++; 
		return cards[nextCard];
	}
	/**
	* this method checks if the object parameter is equal to the Deck created within this instance of the class 
	* @param Object o, knows the card of Card class 
	* @return true if the object is an instance of Deck class, is equal to this instance of cards array and the next card in the arrays are equal 
	* @return false if one of these requirements are not met
	*/
	public boolean equals(Object o){
		if( o instanceof Deck){
			Deck d = (Deck) o;
			return Arrays.equals(cards, d.getCards())
					&& next == d.getNext();
		}
		return false;
	}
	/**
	* this method creates a string includingm(for each card) the card number as index in cards array and ": " plus the card ID and newline 
	* @return String deckString, includes all the cards and thier position on the cards array 
	*/
	public String toString(){
		String deckString = "";
		for(int i = 0; i < cards.length; i++){
			deckString += "card " + i + ": " + cards[i].toString() + "\n";
		}
		return deckString;
	}	
}