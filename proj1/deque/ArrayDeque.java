package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int front;
    private int back;
    /** Creates an empty array deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];  //Java不允许我们创建通用对象的数组
        size = 0;
        front = 0;
        back = 1;
    }
    /** Resizes the array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (capacity > items.length) {
            if (front != items.length - 1) {
                System.arraycopy(items, front + 1, a, 0, items.length - front - 1);
                System.arraycopy(items, 0, a, items.length - front - 1, front + 1);
            } else {
                System.arraycopy(items, 0, a, 0, size);
            }
            items = a;
            front = items.length - 1;
            back = items.length / 2;
        } else {  //缩小容量
            if (front > back) {
                if (front == items.length - 1) {
                    System.arraycopy(items, 0, a, 0, size);
                } else {
                    System.arraycopy(items, front + 1, a, 0, items.length - front - 1);
                    System.arraycopy(items, 0, a, items.length - front - 1, back - 1);
                }
            } else if (front < back) {
                System.arraycopy(items, front + 1, a, 0, size);
            }

            items = a;
            front = items.length - 1;
            back = size;
        }
    }
    /** Inserts X into the first of the list. */
    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        size += 1;
        items[front] = item;
        if (front == 0) {
            front = items.length - 1;
        } else {
            front -= 1;
        }
    }
    /** Inserts X into the back of the list. */
    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        size += 1;
        items[back] = item;
        if (back == items.length - 1) {
            back = 0;
        } else {
            back += 1;
        }
    }
    // /** Returns true if deque is empty, false otherwise. */
    /*


    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    */
    /** Returns the number of items in the deque. */
    @Override
    public int size() {
        return size;
    }
    /** Prints the items in the deque from first to last. */
    @Override
    public void printDeque() {
        if (size != 0) {
            if (front != items.length - 1) {
                for (int i = front + 1; i < items.length; i++) {
                    System.out.print(items[i]);
                    System.out.print(' ');
                }
            }
            for (int i = 0; i < front + 1; i++) {
                System.out.print(items[i]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    /** Removes and returns the item at the front of the deque. */
    @Override
    public T removeFirst() {
        if (size != 0) {
            if (front != items.length - 1) {
                front += 1;
            } else {
                front = 0;
            }
            T x = items[front];
            items[front] = null;
            size -= 1;
            if (items.length >= 16 && size < items.length / 4) {
                resize(items.length / 2);
            }
            return x;
        }
        return null;
    }
    /** Removes and returns the item at the back of the deque. */
    @Override
    public T removeLast() {
        if (size != 0) {
            if (back != 0) {
                back -= 1;
            } else {
                back = items.length - 1;
            }
            T x = items[back];
            items[back] = null;
            size -= 1;
            if (items.length >= 16 && size < items.length / 4) {
                resize(items.length / 2);
            }
            return x;
        }
        return null;
    }
    /** Gets the item at the given index. */
    @Override
    public T get(int index) {
        if (index < size) {
            index = front + index + 1;
            if (index < items.length) {
                return items[index];
            } else {
                return items[index - items.length];
            }
        }
        return null;
    }
    /** return an iterator. */
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }
    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;
        ArrayDequeIterator() {
            wizPos = 0;
        }
        public boolean hasNext() {
            return wizPos < size;
        }
        public T next() {
            int n = front + 1 + wizPos;
            wizPos += 1;
            if (n < items.length) {
                return items[n];
            } else {
                return items[n - items.length];
            }
        }
    }
    /** Returns whether or not the parameter o is equal to the Deque. */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof Deque) {

            Deque p = (Deque) o;
            if (p.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!(this.get(i).equals(p.get(i)))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
