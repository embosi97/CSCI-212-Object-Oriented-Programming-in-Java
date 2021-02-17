package generics;
/**
 * <p>
 * Title: The Stack Empty Exception 
 * </p>
 * 
 * <p>
 * Description: Checks whether or not the Stack is full or not
 * 
 * 
 * 
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author E. B.
 * @version 0.9
 */
public class StackFullException extends RuntimeException {
	
	public StackFullException(){
		super("Exception : Stack is full");
	}

	public StackFullException(String msg){
		super(msg);
	}
}