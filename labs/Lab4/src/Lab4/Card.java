package Lab4;
/**
 * <p>
 * Title: The Card Class
 * </p>
 * 
 * <p>
 * Description: Defines the properties and behaviors of a single playing card.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author A. Abreu
 * @version 0.9
 */
public class Card {
	/**
	 * rank - an integer between 0 - 12 representing the card
	 */
	private int rank;
	/**
	 * suit - an integer between 0 - 3 representing the card
	 */
	private int suit;

	/**
	 * Card default constructor -- gets called when an object of the Card class
	 * is instantiated -- rank and suit are randomly defined
	 */
	public Card() {
		rank = (int) (Math.random() * 13);
		suit = (int) (Math.random() * 4);
	}

	/**
	 * Card constructor -- gets called when an object of the Card class is
	 * instantiated -- based upon the number received it determines the rank and
	 * suit of the card
	 * 
	 * @param n a number between 0 and 51 that gets converted to a value
	 * between 0 and 12 for rank and a value between 0 and 3 for suit
	 */
	public Card(int n) {
		if (n >= 0 && n <= 51) {
			rank = n % 13;
			suit = n / 13;
		}
	}

	/**
	 * Card constructor -- gets called when an object of the Card class is
	 * instantiated -- r represents the rank, and s represents the suit of the
	 * card
	 * 
	 * @param r
	 *            a number between 0 and and 12 representing the rank
	 * @param s
	 *            a number between 0 and and 3 representing the suit
	 */
	public Card(int r, int s) {
		if ((r >= 0 && r <= 12) && (s >= 0 && s <= 3)) {
			rank = r;
			suit = s;
		}
	}

	/**
	 * toString method -- this method returns the state of the Card object
	 * 
	 * @return a reference to a string object that contains the values stored in
	 *         the instance variables
	 */
	public String toString() {
		String c = getRankAsString() + " " + "of " + getSuitAsString() + "\n";
		c = c.replace(",", "").replace("[", "").replace("]", "");
		return c;
		}

	/**
	 * setRank method -- modifies the value of the instance variable rank
	 * 
	 * @param r
	 *            a number between 0 and and 12 representing the rank
	 */
	public void setRank(int r) {
		if (r >= 0 && r <= 12)
			rank = r;
	}

	/**
	 * setSuit method -- modifies the value of the instance variable suit
	 * 
	 * @param s
	 *            a number between 0 and and 3 representing the suit
	 */
	public void setSuit(int s) {
		if (s >= 0 && s <= 3)
			suit = s;
	}

	/**
	 * getRank method -- returns what's stored in the instance variable rank
	 * 
	 * @return the state of the instance variable rank
	 */
	public int getRank() {

		return rank;
	}

	/**
	 * getSuit method -- returns what's stored in the instance variable suit
	 * 
	 * @return the state of the instance variable suit
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * getRankAsString method -- returns a String representation of the instance
	 * variable rank
	 * 
	 * @return the state of the instance variable rank as a String
	 */
	public String getRankAsString() {
		String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" }; // 0-12
		return ranks[rank];
	}

	/**
	 * getSuitAsString method -- returns a String representation of the instance
	 * variable suit
	 * 
	 * @return the state of the instance variable suit as a String
	 */
	public String getSuitAsString() {
		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" }; // 0-3
		return suits[suit];
	}

	/**
	 * equals -- this method indicates whether some other Card is "equal to"
	 * this one.<br>
	 * 
	 * @param otherCard
	 *            a reference to a Card object with which to compare
	 * @return true if this Card is the same as the otherCard; false otherwise.
	 */
	public boolean equals(Card otherCard) {
		return ((rank == otherCard.rank) && (suit == otherCard.suit));
	}

	/**
	 * compareByRank -- this method compares 2 Card objects by rank and returns
	 * a negative integer, zero, or a positive integer as this Card is less
	 * than, equal to, or greater than the other Card.<br>
	 * For example the following call: <b>card1.compareByRank(card2);</b><br>
	 * compares if the rank of card1 is greater than card2, is equal to card2,
	 * or is less than card2 and returns the appropriate value<br>
	 * 
	 * @param otherCard
	 *            a reference to a Card object
	 * @return negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the other Card.
	 */
	public int compareByRank(Card otherCard) {
		return rank - otherCard.rank;
	}

	/**
	 * compareBySuit -- this method compares 2 Card objects by suit and returns
	 * a negative integer, zero, or a positive integer as this Card is less
	 * than, equal to, or greater than the other Card.<br>
	 * For example the following call: <b>card1.compareBySuit(card2);</b><br>
	 * compares if the suit of card1 is greater than card2, is equal to card2,
	 * or is less than card2 and returns the appropriate value<br>
	 * 
	 * @param otherCard
	 *            a reference to a Card object
	 * @return negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the other Card.
	 */
	public int compareBySuit(Card otherCard) {
		return suit - otherCard.suit;
	}
}