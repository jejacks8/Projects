import java.util.*;
import java.lang.*;

public class Player{
	//class constants 
	public static final int CARDS_IN_HAND = 13;  //knows how many cards in players hand 
	
	//instance fields 
	private String name; //knows the name of the player 
	private int overallPoints; //knows the integer value of the players overall points in teh game 
	private int handPoints; //knows the integer value of the players points in hand 
	private Card[] hand;  // array of card objects that make up the players hand
	private int next; //integer value that knows which card is next
	
	/**
	* this method is a contructor class for a new player object
	* @param String playerName, this contains the string given by the user in the command arguments 
	* assigns intance field name to the parameter passed
	* initizalizes hand, Card array to the amount of cards a player can have in their hand
	*/
	public Player (String playerName){
		name = playerName;
		System.out.println(name);
		hand = new Card[CARDS_IN_HAND];
	}
	/**
	* this method simply returns the insatnce field name which knows the name of the player
	* @return name, instance field that knows name of player
	*/
	public String getName(){
		return name;
	}
	/**
	* this method adds a card from the deck to the players hand
	* @param Card card, Card object card contains information of a card from the deck
	* @throws IllegalStateException if the player has a full hand with the message "Full Hand"
	* sorts the cards in the array hand
	* adds one to the instance field that knws which card is next 
	*/
	public void addCard(Card card){
		
		if( next >= CARDS_IN_HAND){
			throw new IllegalStateException( "Full Hand");
		}
		hand[next] = card;
		if(next == hand.length - 1){
			Arrays.sort(hand);
		}
		next++;
	}
	/**
	* this method returns the instance field handPoints
	* @return instance field handPoints, knows the integer value of the points the player posses in their current hand
	*/
	public int getHandPoints(){
		return handPoints;
	}
	/**
	* this method returns the instance field overallPoints
	* @return overallPoints, integer instance field that knows how many points a player has total
	*/
	public int getOverallPoints(){
		return overallPoints;
	}
	/** 
	* this method adds the points parameter to both the handPoints and overallPoints instance fields 
	* @param integer points, knows the amount of points to be added to scores
	*/
	public void addToHandPoints(int points){
		handPoints = handPoints + points;
		overallPoints = overallPoints + points;
	}
	/** 
	* this method gets the next card in the hand based on the paramter passed
	* @param integer index, knows which index of array hand to return 
	* @throws IllegalArgumentException if an integer that is less than zero or greater than CARDS_IN_HAND is passed
	* @return the card at index (index) 
	*/
	public Card getCard(int index){
		if(index < 0 || index >= CARDS_IN_HAND){
			throw new IllegalArgumentException("Invalid index");
		}
		return hand[index];
	}
	/**
	* this method checks for a nonplayed card of the given suit in the players hand and then returns true or false
	* @return true if there is a card of given suit and has not been played yet
	* @return false if requirements are not met 
	* @throws IllegalStateException if the player does not have a full hand
	*/
	public boolean hasActiveCardOfSuit(char suit) {
		if(next < CARDS_IN_HAND){
			throw new IllegalStateException("Hand not full");
		}
		for(int i = 0; i < hand.length; i++){
			if(hand[i].getSuit() == suit && hand[i].hasBeenPlayed()){
				return true;
			}
		}
		
		return false;
	}
	/**
	* this method checks if the players hand contains only hearts and if all thier cards have been played
	* @return true if there is even one card that is not hearts and has not been played yet 
	* @return false otherwise 
	* @throw IllegalStateException if the player does not have a full hand 
	*/
	public boolean onlyHasHearts(){
		if(next < CARDS_IN_HAND){
			throw new IllegalStateException("Hand not full");
		}
		for(int i = 0; i < hand.length; i++){
			if(hand[i].getSuit() != 'h'){
				if(!hand[i].hasBeenPlayed()){
					return false;
				}
			}
		}
		
		return true;
	}	
	/**
	* this method returns a string array that contains each name for the card in the hand of the player 
	* @throw IllegalStateException if the player has a hand that is not full 
	* @return String[] cardNames, includes each name of card at corresponding element in hand array 
	*/
	public String[] getCardNames(){
		String[] cardNames = new String[CARDS_IN_HAND];
		if(next < CARDS_IN_HAND){
			throw new IllegalStateException("Hand not full");
		}
		for(int i = 0; i < cardNames.length; i++){
			cardNames[i] = hand[i].toString();
		}
		
		return cardNames;
	}
	/**
	* returns the String playerStatus that includes "name: pts" 
	* @return playerStatus, String that knows the name of the player and thier points 
	*/
	public String toString(){
		
		String playerStatus = "";
		playerStatus += name + ": " + overallPoints;
		return playerStatus;
	}
	/**
	* this method dumps the cards in the players hands 
	* sets the instace field that knows which card is next to 0 
	*/
	public void dumpCards(){
		for( int i = 0; i < hand.length; i++){
			hand[i] = null;
		}
		next = 0;
	}
	/**
	* this method resets the instance field that knows how many points a player has in their current hand
	*/
	public void resetHandPoints(){
		handPoints = 0;
	}
	    /*
     * This method determines the card that a computer player will play in the
     * current round (trick). This method assumes the hand has been sorted and
     * is in order by suits - clubs, diamond, spades, hearts - and the values of
     * the cards in each suit are ordered from lowest to highest value.
     * @param startingCard the card that started the round
     * @param isFirstRound whether or not this is the first round of a hand
     * @param heartsStarted whether or not hearts are in play at this point in the hand
     * @return the card that will be played
     */
    public Card getMove(Card startingCard, boolean isFirstRound, boolean heartsStarted) {
        
        //If this is the first round (trick) and the computer player has the 2 of Clubs, 
        //they must play it. If the player has the 2 of Clubs, it should be the first 
        //card in their (sorted) hand
        if (isFirstRound && startingCard == null && 
            hand[0].getSuit() == Card.CLUBS && hand[0].getValue() == 2) {
            hand[0].setPlayed(true);
            return hand[0];
        } 
        
        //If an initial card was played, the computer player must follow suit
        //and will play the lowest card in that suit
        if (startingCard != null) {
            char currentSuit = startingCard.getSuit(); 
            for (int i = 0; i < CARDS_IN_HAND; i++) {
                if (!hand[i].hasBeenPlayed() && hand[i].getSuit() == currentSuit) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }
            }
        }

        //If no card with a matching suit was found and it's not the first round(trick)
        //the computer player will play the Queen of Spades if they have it and it
        //hasn't been played yet
        //If not, they will play their highest valued Heart, if they have one and it
        //hasn't been played yet
        if (startingCard != null && !isFirstRound) {
            //Look for the Queen of Spades
            for (int i = 0; i < CARDS_IN_HAND; i++) {
                if (hand[i].getSuit() == Card.SPADES && hand[i].getValue() == Card.QUEEN_VALUE &&
                    !hand[i].hasBeenPlayed()) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }
            }
            for (int i = CARDS_IN_HAND - 1; i >= 0; i--) {
                if (hand[i].getSuit() == Card.HEARTS && !hand[i].hasBeenPlayed()) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }
            }
        }

        //If no card has been found yet, the first card that hasn't been played
        //in the sorted hand will be played
        for (int i = 0; i < hand.length; i++) {
            if (!hand[i].hasBeenPlayed()) {
                
                //A club or diamond is always valid
                if (hand[i].getSuit() == Card.CLUBS ||
                    hand[i].getSuit() == Card.DIAMONDS) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }
                
                //All spades other than the queen are valid
                //The queen of spades can be played if it's not the
                //first round(trick)
                if (hand[i].getSuit() == Card.SPADES) {
                    if (hand[i].getValue() != Card.QUEEN_VALUE) {
                        hand[i].setPlayed(true);
                        return hand[i];
                    }
                    else if (!isFirstRound) {
                        hand[i].setPlayed(true);
                        return hand[i];
                    }
                }
                
                //A heart is valid if it's not the first round 
                //and either hearts have been played previously or
                //the player only has hearts. NOTE: This case would 
                //occur when the player is playing the initial card
                //in the trick
                if (hand[i].getSuit() == Card.HEARTS && !isFirstRound && 
                    (heartsStarted || onlyHasHearts())) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }    
            }
        }
        //No card found so far - this could happen in the unlikely situation
        //that the player's hand contained only hearts or
        //the Queen of spades with the rest of the cards being hearts
        //Return the first unplayed card        
        for (int i = 0; i < hand.length; i++) {
            if (!hand[i].hasBeenPlayed()) {
               hand[i].setPlayed(true);
               return hand[i];
            }
        }
        //No unplayed card in hand
        throw new IllegalStateException("No unplayed card in hand");

    }
	
		
				
		
		
}