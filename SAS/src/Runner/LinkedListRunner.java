//$Id$
package Runner;

import java.util.Scanner;

import LinkedList.*;

public class LinkedListRunner {
public static void main(String[] args){
LinkedList<Integer> x=new LinkedList<Integer>();
Scanner sc = new Scanner(System.in);
	label: do {
		System.out.println("1.Add element\n2.Add at start\n3.Add at\n4.Delete\n5.show");
		switch (sc.nextInt()) {
		case 1:
			x.add(sc.nextInt());
			break;
		case 2:
			x.addAtStart(sc.nextInt());
			break;
		case 3:
			System.out.println("Enter Index & Element");
			x.addAt(sc.nextInt(), sc.nextInt());
			break;
		case 4:
			x.delete(sc.nextInt());
			break;
		case 5:
			x.show();
			break;
		default:
			break label;
		}
	} while (true);
sc.close();
}
}
