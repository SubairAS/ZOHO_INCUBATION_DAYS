package stack;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArray<E> implements Stack<E>{
	private List<E> stack = new ArrayList<E>();
	private int top = 0;
	public E pop() {
		E poppedElement = null;
		if (!isEmpty()) {
			poppedElement = stack.get(--top);
			stack.remove(top);
		}
		return poppedElement;
	}

	public void push(E data) {
		top++;
		stack.add(data);
	}

	public boolean isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return top;
	}

	public void show() {
		if(isEmpty()){
			System.out.println("Empty");
			return;
		}
		System.out.println("Elements");
		for (int i=0;i<top;i++) {
			System.out.println(stack.get(i));
		}
	}
	public E peek() {
		return stack.get(top);
	}
}