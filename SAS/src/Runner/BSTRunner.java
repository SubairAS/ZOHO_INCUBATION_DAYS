//$Id$
package Runner;

import java.util.Scanner;

import Tree.*;

public class BSTRunner {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Scanner sc = new Scanner(System.in);
		label: {
			do {
				System.out.println("1.Insert\n2.Traverse\n3.Find");
				switch (sc.nextInt()) {
				case 1:
					tree.insert(sc.nextInt());
					break;
				case 2:
					System.out.println("1.In order\n2.Pre-Order\n3.Post-Order\n4.Level Order");
					switch (sc.nextInt()) {
					case 1:
						tree.inOrder();
						break;
					case 2:
						tree.preOrder();
						break;
					case 3:
						tree.postOrder();
						break;
					case 4:
						tree.levelOrder();
						break;
					}
					break;
			case 3:
				System.out.println(tree.contains(sc.nextInt()));
				break;
				default:
					break label;
				}
			} while (true);
		}
		sc.close();
	}
}
