//$Id$
package Queue;

import java.util.Collection;

public interface Queue<E> {
public void enqueue(E data);
public E dequeue();
public boolean isEmpty();
public int size();
public void show();
public E peek();
public void addAll(Collection<E> c);
}
