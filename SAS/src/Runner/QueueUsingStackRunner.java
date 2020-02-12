//$Id$
package Runner;

import java.util.Scanner;

import Queue.QueueUsingStack;;

public class QueueUsingStackRunner {
	public static void main(String[] args) {
		QueueUsingStack<Integer> queue= new QueueUsingStack<Integer>();
		System.out.println("Queue Using Stack");
		Scanner sc = new Scanner(System.in);
		label: do {
			System.out.println("1.Enqueue\n2.Dequeue\n3.Size\n4.isEmpty\n5.Show All");
			switch (sc.nextInt()) {
			case 1:
				queue.enqueue(sc.nextInt());
				break;
			case 2:
				System.out.println(queue.dequeue());
				break;
			case 3:
				System.out.println(queue.size());
				break;
			case 4:
				System.out.println(queue.isEmpty());
				break;
			case 5:
				queue.show();
				break;
			default:
				break label;
			}
			System.out.println();
//			n.show();
		} while (true);
		sc.close();
	}
}
