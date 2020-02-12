package Runner;
//$Id$

import java.util.Scanner;

import Queue.Queue;
import Queue.QueueWithGenerics;
public class QueueWithGenericsRunner<E> {
	public static void main(String[] args) {
			Queue<Integer> n = new QueueWithGenerics<Integer>();
			Scanner sc = new Scanner(System.in);
			label: do {
				System.out.println("1.Enqueue\n2.Dequeue\n3.Size\n4.isEmpty\n5.Show All");
				switch (sc.nextInt()) {
				case 1:
					n.enqueue(sc.nextInt());
					break;
				case 2:
					System.out.println(n.dequeue());
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
				case 6:
					n.peek();
					break;
				default:
					break label;
				}
//				n.show();
			} while (true);
			sc.close();
	}
}
