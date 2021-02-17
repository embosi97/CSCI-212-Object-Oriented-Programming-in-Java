package generics;
/**
 * <p>
 * Title: The Stack Empty Exception 
 * </p>
 * 
 * <p>
 * Description: Checks whether or not the Stack is empty or not
 * 
 * 
 * 
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author E. B.
 * @version 0.9
 */
public class StackEmptyException extends Exception {

	public StackEmptyException(){
		super("Exception : Stack is empty");
	}

	public StackEmptyException(String msg){
		super(msg);
	}
}