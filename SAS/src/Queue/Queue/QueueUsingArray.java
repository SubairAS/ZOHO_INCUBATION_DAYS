////$Id$
package Queue;
//
//public class QueueUsingArray implements Queue {
//	private int cap = 2;
//	private int[] queue = new int[cap];
//	private int rear = -1, front = -1;
//
//	public void enqueue(int data) {
//		rear++;
//		if (isFull()) {
//			expand();
//		}
//		queue[rear] = data;
//	}
//
//	public int dequeue() {
//		int poppedElement = -1;
//		if (!isEmpty()) {
//			poppedElement = queue[++front];
//		}
//		if (rear < cap / 2) {
//			shrink();
//		}
//		return poppedElement;
//	}
//
//	private void expand() {
//		cap *= 2;
//		int[] temp = new int[cap];
//		System.arraycopy(queue, 0, temp, 0, queue.length);
//		queue = temp;
//	}
//
//	private void shrink() {
//		cap /= 2;
//		int[] temp = new int[cap];
//		System.arraycopy(queue, 0, temp, front, rear + 1);
//		queue = temp;
//	}
//
//	private boolean isFull() {
//		if (cap == rear) {
//			return true;
//		}
//		return false;
//	}
//
//	public boolean isEmpty() {
//		if (rear == front) {
//			return true;
//		}
//		return false;
//	}
//
//	public int size() {
//		return rear - front;
//	}
//
//	public void show() {
//		System.out.println("Elements");
//		for (int i = front + 1; i <= rear; i++) {
//			System.out.println(queue[i]);
//		}
//	}
//}
