//$Id$
package Runner;

import java.util.Scanner;
import stack.StackUsingQueue;

public class StackUsingQueueRunner {
	public static void main(String[] args) {
		StackUsingQueue<Integer> stack = new StackUsingQueue<Integer>();
		System.out.println("Stack using queue");
		Scanner sc = new Scanner(System.in);
		label: do {
			System.out.println("1.Push\n2.Pop\n3.Size\n4.isEmpty\n5.show all");
			switch (sc.nextInt()) {
			case 1:
				stack.push(sc.nextInt());
				break;
			case 2:
				System.out.println(stack.pop());
				break;
			case 3:
				System.out.println(stack.size());
				break;
			case 4:
				System.out.println(stack.isEmpty());
				break;
			case 5:
				stack.show();
				break;
			default:
				break label;
			}
//			n.show();
		} while (true);
		sc.close();
	}
}
