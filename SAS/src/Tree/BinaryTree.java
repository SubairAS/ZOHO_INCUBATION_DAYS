package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	Node root;

	public void insert(int value) {
		if (root == null) {
			root = new Node(value);
			return;
		}
		insert(root, value);
	}

	private void insert(Node node, int value) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.left == null) {
				current.left = new Node(value);
				return;
			} else {
				queue.add(current.left);
			}
			if (current.right == null) {
				current.right = new Node(value);
				return;
			} else {
				queue.add(current.right);
			}
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.data);
		inOrder(node.right);
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data);
	}

	public void levelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			System.out.println(current.data);
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node node, int value) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			System.out.println(current.data);
			if (current.data == value) {
				return true;
			}
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
		return false;
	}
}