//$Id$
package Runner;

import java.util.Scanner;
import stack.StackUsingArray;;

public class StackRunner {
	public static void main(String[] args) {
		StackUsingArray<Integer> n = new StackUsingArray<Integer>();
		System.out.println("Stack");
		Scanner sc = new Scanner(System.in);
		label: do {
			System.out.println("1.Push\n2.Pop\n3.Size\n4.isEmpty\n5.show all");
			switch (sc.nextInt()) {
			case 1:
				n.push(sc.nextInt());
				break;
			case 2:
				System.out.println(n.pop());
				break;
			case 3:
				System.out.println(n.size());
				break;
			case 4:
				System.out.println(n.isEmpty());
				break;
			case 5:
				n.show();
				break;
			default:
				break label;
			}
//			n.show();
		} while (true);
		sc.close();
	}
}
