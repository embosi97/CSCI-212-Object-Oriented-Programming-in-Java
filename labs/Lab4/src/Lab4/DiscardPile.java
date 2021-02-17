package Lab4;

import generics.StackEmptyException;
import generics.StackFullException;

import java.util.Stack;
/**
 * <p>
 * Title: The DiscardPile Class
 * </p>
 * 
 * <p>
 * Description: Calls the constructor of @Stack.java
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author E. B.
 * @version 0.9
 */

public class DiscardPile<T> extends Stack<T>  { //subclass of its parent Stack
	/**
	 * 
	 * Calling of the private constructor's instance variables, specifically size and data 
	 * 
	 */
		 public DiscardPile(int i, int z) {
		 super();
		 }
	/**
		 * 
		 * Creating the removeTopCard with the @param otherCard that'll be used to compare the rank and suit to the popped cards
		 * @return the popped cards of whatever it over Card top, including top itself
	 */
	public Card[] removeTopCard(Card otherCard) throws StackEmptyException {

	    Card[] theCard = new Card[size()]; //creating an object Card
	    int i = 0;
	    boolean check = false;	    
	    if(isEmpty()){ //in the case that there's nothing there
	      throw new StackEmptyException("Stack is Empty");
	    }
	    while(!isEmpty()){ //If it's not empty, pop the top card (unlimited loop that'll need to be broken by a break;)	    	
	      Card top = (Card) pop(); //Casts Card to pop, which should remove it
	      theCard[i] = top; //removed and returned in an array
	      i++; //keeps adding another card until the loop is broken
	      if(top.equals(otherCard)){ //checks if the card's rank and suit are the same and stops the loop if true
	        check = true;
	        break; //it ends the loop if they're equivalent, all of those cards were set to top
	      }
	    }
	    if(!check){ //if it can't find anything
	      throw new StackEmptyException("Card not found");
	    }
	    Card[] topCards = new Card[i];
	    for(int j = 0;j < i; j++){ //for loop through the popped cards

	      topCards[j] = theCard[j]; //set the discarded value array to theCard
	    }
	    return topCards; //should return the popped numbers

	  }



	

}