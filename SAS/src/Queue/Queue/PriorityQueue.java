//package Queue;
//
//import java.util.Collection;
//import java.util.Iterator;
//
//class Node<E> {
//	public E data;
//	public int priority;
//	public Node<E> next;
//}
//
//public class PriorityQueue<E> implements Queue<E> {
//	private Node<E> root;
//	public void enqueue(E data) {
//		Node<E> newNode=new Node<E>();
//		newNode.data=data;
//		newNode.priority=5;
//		if(root==null) {
//			root=newNode;
//		}
//		else {
//			Node<E> currentNode=root;
//			while(currentNode.next!=null&&currentNode.next.priority<=newNode.priority) {
//				currentNode=currentNode.next;
//			}
//			currentNode.next=newNode;
//		}
//	}
////	public void enqueue(E data,int priority) {
////		Node<E> newNode=new Node<E>();
////		newNode.data=data;
////		newNode.priority=priority;
////		if(root==null) {
////			root=newNode;
////		}
////		else {
////			Node<E> currentNode=root;
////			while(currentNode.next!=null&&currentNode.priority<=newNode.priority) {
////				currentNode=currentNode.next;
////			}
////			if(currentNode==root) {
////				newNode.next=root;
////				root=newNode;
////				return;
////			}
////			newNode.next=currentNode.next;
////			currentNode.next=newNode;
////		}
////	}
//	public E dequeue() {
//		Node<E> newNode=root;
//		root=root.next;
//		return newNode.data;
//	}
//	public E peek() {
//		return root.data;
//	}
//	public boolean isEmpty() {
//		if(root==null) {
//			return true;
//		}
//		return false;
//	}
//	public int size() {
//		int size=0;
//		Node<E> currentNode=root;
//		while(currentNode!=null) {
//			currentNode=currentNode.next;
//			size++;
//		}
//		return size;
//	}
//	public void show() {
//		Node<E> currentNode=root;
//		while(currentNode!=null) {
//			System.out.println(currentNode.data+" "+currentNode.priority);
//			currentNode=currentNode.next;
//		}
//	}
//	public void addAll(Collection<E> c) {
//		Iterator<E> iterator=c.iterator();
//		for(int i=0;i<c.size();i++) {
//			if(iterator.hasNext()) {
//				enqueue(iterator.next());
//			}
//			else {
//				break;
//			}
//		}
//	}
//}
