//$Id$
package LinkedList;

public class LinkedList<E> {
	private Node<E> head;

	public void add(E data) {
		Node<E> New = new Node<E>();
		New.data = data;
		if (head == null) {
			head = New;
		} else {
			Node<E> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = New;
		}
	}

	public void addAtStart(E data) {
		Node<E> New = new Node<E>();
		New.data = data;
		New.next = head;
		head = New;
	}

	public void addAt(int index, E data) {
		if (index == 0) {
			addAtStart(data);
		} else {
			Node<E> temp = head;
			for (int i = 1; i < index; i++) {
				temp = temp.next;
			}
			Node<E> New = new Node<E>();
			New.data = data;
			New.next = temp.next;
			temp.next = New;
		}
	}

	public void delete(int index) {
		Node<E> temp = head;
		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
	}

	public void show() {
		Node<E> temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}

class Node<E> {
	E data;
	Node<E> next;
}