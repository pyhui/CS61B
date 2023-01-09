
package deque;

import org.junit.Assert;

import java.util.Iterator;

public class LinkedListDeque<T> {
    /** Creates a double linked list. */
    private class IntNode {
        public IntNode prev;
        public T item;
        public IntNode next;

        public IntNode(IntNode m, T i, IntNode n) {
            prev = m;
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        //sentinel.prev = sentinel;
        //sentinel.next = sentinel;
        size = 0;

    }

    /** Adds item to the front of the list. */
    public void addFirst(T item) {
        if (size == 0) {
            IntNode p = new IntNode(sentinel, item, sentinel);
            sentinel.next = p;
            sentinel.prev = p;
        } else {
            IntNode p = new IntNode(sentinel, item, sentinel.next);
            sentinel.next.prev = p;
            sentinel.next = p;
        }
        size += 1;
    }
    /** Adds item to the back of the list. */
    public void addLast(T item) {
        if (size == 0) {
            IntNode p = new IntNode(sentinel, item, sentinel);
            sentinel.prev = p;
            sentinel.next = p;
        } else {
            IntNode p = new IntNode(sentinel.prev, item, sentinel);
            sentinel.prev.next = p;
            sentinel.prev = p;
        }
        size += 1;
    }
    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }
    /** Prints the items in the deque from first to last. */
    public void printDeque() {
        if (size != 0) {
            IntNode p = sentinel;
            while (p.next != sentinel) {
                System.out.print(p.item);
                System.out.print(' ');
                p = p.next;
            }
            System.out.println(p.item);
        }
    }
    /** Removes and returns the item at the front of the deque. */
    public T removeFirst() {
        if (size != 0) {
            size -= 1;
            //IntNode p = sentinel.next;
            T x = sentinel.next.item;
            if (size == 0) {
                sentinel.prev = sentinel;
                sentinel.next = sentinel;
            } else {
                sentinel.next.next.prev = sentinel;
                sentinel.next = sentinel.next.next;
            }
            return x;
        }
        return null;
    }
    /** Removes and returns the item at the back of the deque. */
    public T removeLast() {
        if (size != 0) {
            size -= 1;
            T x = sentinel.prev.item;
            if (size == 0) {
                sentinel.prev = sentinel;
                sentinel.next = sentinel;
            } else {
                sentinel.prev.prev.next = sentinel;
                sentinel.prev = sentinel.prev.prev;
            }
            return x;
        }
        return null;
    }
    /** Gets the item at the given index. */
    public T get(int index) {
        if (index < size) {
            IntNode p = sentinel;
            for (int i = 0; i <= index; i++) {
                p = p.next;
            }
            T x = p.item;
            return x;
        }
        return null;
    }
    /** Gets the item at the given index, but uses recursion. */
    private T getRecursive_helper(IntNode x, int index) {
        if (size == 0 || index > size) {
            return null;
        } else if (index == 0) {
            return x.next.item;
        } else {
            return getRecursive_helper(x.next, index - 1);
        }
    }
    public T getRecursive(int index) {
        IntNode p = sentinel;
        return getRecursive_helper(p,index);
    }

    /** return an iterator. */
    //public Iterator<T> iterator() {

    //}
    /** Returns whether or not the parameter o is equal to the Deque. */
    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque) {
            LinkedListDeque p = (LinkedListDeque) o;
            if (p.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++){
                if (this.get(i) != p.get(i)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
