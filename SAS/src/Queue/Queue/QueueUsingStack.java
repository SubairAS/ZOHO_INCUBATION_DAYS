//$Id$
package Queue;

import stack.Stack;
import stack.StackUsingArray;

import java.util.Collection;
import java.util.Iterator;

import Queue.Queue;

public class QueueUsingStack<E> implements Queue<E> {
	private Stack<E> queue = new StackUsingArray<E>();
	private int front = 0, rear = 0;

	public void enqueue(E data) {
		queue.push(data);
		rear++;
	}

	public E dequeue() {
		E poppedElement = null;
		if (!isEmpty()) {
			Stack<E> temp = new StackUsingArray<E>();
			Stack<E> temp1 = new StackUsingArray<E>();
			for (int i = front; i <= rear; i++) {
				temp.push(queue.pop());
			}
			poppedElement = (E)queue.pop();
			front++;
			for (int i = front-1; i <= rear; i++) {
				temp1.push(temp.pop());
			}
			queue = temp1;			
		}
		return poppedElement;
	}
	public int size() {
		return rear - front ;
	}

	public boolean isEmpty() {
		if (size()==0) {
			return true;
		}
		return false;
	}

	public void show() {
		queue.show();
	}
	public E peek() {
		return queue.peek();
	}
	
	public void addAll(Collection<E> c) {
		Iterator<E> iterator=c.iterator();
		for(int i=0;i<c.size();i++) {
			if(iterator.hasNext()) {
				enqueue(iterator.next());
			}
			else {
				break;
			}
		}
	}
}
