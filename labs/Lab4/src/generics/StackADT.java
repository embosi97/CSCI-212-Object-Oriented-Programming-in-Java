package generics;

public interface StackADT<T> {
	/**
	 * Pushes an object onto the top of this stack.
	 * @param element The object to be stored onto the stack.
	 * @throws StackFullException - if this stack is full
	 */
	void push(T element) throws StackFullException;
	/**
	 * Removes and returns the object at the top of this stack.
	 * @return The object at the top of the stack.
	 * @throws StackEmptyException - if this stack is full
	 */
	T pop() throws StackEmptyException;
	/**
	 * Returns the object at the top of this stack without removing it.
	 * @return The object at the top of the stack.
	 * @throws StackEmptyException - if this stack is full
	 */
	T peek() throws StackEmptyException;
	
	int getSize();
}