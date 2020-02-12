//$Id$
package stack;

public interface Stack<E> {
public void push(E data);
public E pop();
public boolean isEmpty();
public int size();
public void show();
public E peek();
}
