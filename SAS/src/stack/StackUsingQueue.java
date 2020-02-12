//$Id$
package stack;

import Queue.*;

public class StackUsingQueue<E> implements Stack<E> {
	private Queue<E> stack = new QueueWithGenerics<E>();
	private int top = 0;
	
	public void push(E data) {
		stack.enqueue(data);
		top++;
	}

	public E pop() {
		if (!isEmpty()) {
			E poppedElement = (E)stack.dequeue();
			for (int i = 1; i < top; i++) {
				stack.enqueue(poppedElement);
				poppedElement = (E)stack.dequeue();
			}
			top--;
			return poppedElement;
		}
		return null;
	}

	public void show() {
		if (!isEmpty()) {
			E poppedElement;
			for (int i = 0; i < top; i++) {
				poppedElement = (E)stack.dequeue();
				System.out.println(poppedElement);
				stack.enqueue(poppedElement);
			}
		} else {
			System.out.println("Stack is empty");
		}
	}

	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return top ;
	}
	public E peek() {
		return stack.peek();
	}
}