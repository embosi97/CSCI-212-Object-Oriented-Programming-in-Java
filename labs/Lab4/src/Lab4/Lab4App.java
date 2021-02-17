package Lab4;
/**
 * <p>
 * Title: Lab4App, The Testing Class
 * </p>
 * 
 * <p>
 * Description: Tests the removeTopCard and the push() method
 * </p>
 * @throws checks if the stack is empty or full
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author E. B.
 * @version 0.9
 */
import java.util.Collections;
import java.util.List;

import generics.StackFullException;
import generics.StackEmptyException;

/**
 * @author E. B.
 *
 */
public class Lab4App extends Card {
	   public static void main(String[] args) throws StackFullException, StackEmptyException {
	    /**
	     * 
	     * try will look out for the catch statements at the bottom 
	     * The new DiscardPile class has a carrying capacity of 52 and an initial size of 0, hence "new DiscardPile<Card>(52, 0);"
	     * 
	     */
	    try {
	    DiscardPile<Card> discardPile1 = null; 
		discardPile1 = new DiscardPile<Card>(52, 0);// max is 52
		discardPile1.push(new Card(8));
		discardPile1.push(new Card(32));
		discardPile1.push(new Card(48));		
		discardPile1.push(new Card(2));
		discardPile1.push(new Card(17));
		discardPile1.push(new Card(20)); //removeTopCard should remove all that's above
		discardPile1.push(new Card(25));
		discardPile1.push(new Card(50));
		discardPile1.push(new Card(19));
		discardPile1.push(new Card(41)); //10 Cards that must be popped
		System.out.println("*********************************************************************************"); 
		Collections.reverse(discardPile1);
		for(Card comi : discardPile1) { //for loop for objects
			System.out.println(comi);
			}			
	    }
	    catch (StackFullException SFE) {
	    System.out.println("StackFullException: " + SFE.getMessage());
}
	    try {
			DiscardPile<Card> discardPile = null; 
			discardPile = new DiscardPile<Card>(52, 0);
			discardPile.push(new Card(8));
			discardPile.push(new Card(32));
			discardPile.push(new Card(48));		
			discardPile.push(new Card(2));
			discardPile.push(new Card(17));
			discardPile.push(new Card(20)); //removeTopCard should remove all that's above
			discardPile.push(new Card(25));
			discardPile.push(new Card(50));
			discardPile.push(new Card(19));
			discardPile.push(new Card(41)); //10 Cards that must be popped
			 
			System.out.println("*********************************************************************************"); 
			
			Card[] cardArr = discardPile.removeTopCard(new Card(20));
			for(Card co : cardArr) { //for loop for objects
				System.out.println(co);
				}		
			System.out.println("*********************************************************************************"); 

		    }
		    catch (StackFullException SFE) {
		    	System.out.println("StackFullException: " + SFE.getMessage());
		   }
		    catch (StackEmptyException SEE) {
		    	System.out.println("StackFullException: " + SEE.getMessage());
		    }
	    try {
			DiscardPile<Card> discardPile = null; 
			discardPile = new DiscardPile<Card>(52, 0);
			discardPile.push(new Card(8));
			discardPile.push(new Card(32));
			discardPile.push(new Card(48));		
			discardPile.push(new Card(2));
			discardPile.push(new Card(17));
			discardPile.push(new Card(20)); //removeTopCard should remove all that's above
			discardPile.push(new Card(25));
			discardPile.push(new Card(50));
			discardPile.push(new Card(19));
			discardPile.push(new Card(41)); //10 Cards that must be popped
			 
			
			Card[] cardArr = discardPile.removeTopCard(new Card(50));
			for(Card co : cardArr) { //for loop for objects
				System.out.println(co);
				}		
			System.out.println("*********************************************************************************"); 

		    }
		    catch (StackFullException SFE) {
		    	System.out.println("StackFullException: " + SFE.getMessage());
		   }
		    catch (StackEmptyException SEE) {
		    	System.out.println("StackFullException: " + SEE.getMessage());
		    }

}

	
	   }
	

