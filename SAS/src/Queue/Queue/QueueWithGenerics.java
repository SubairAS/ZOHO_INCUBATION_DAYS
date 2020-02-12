//$Id$
package Queue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class QueueWithGenerics<E> implements Queue<E>{

	private List<E> queue = new ArrayList<E>();
	private int rear = 0, front = 0;
	
	public void enqueue(E data) {
		rear++;
		queue.add(data);
	}

	public E dequeue() {
		E poppedElement=null;
		if (!isEmpty()) {
			poppedElement = queue.get(front++);
		}
		return poppedElement;
	}

	public E peek() {
		if(!isEmpty()) {
		return queue.get(front);
		}
		return null;
	}
	public boolean isEmpty() {
		if (rear == front) {
			return true;
		}
		return false;
	}

	public int size() {
		return rear - front;
	}

	public void show() {
		System.out.println("Elements");
		for (int i = front; i < rear; i++) {
			System.out.println(queue.get(i));
		}
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
