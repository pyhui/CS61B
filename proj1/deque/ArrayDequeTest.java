package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void testAddRemove(){
        LinkedListDeque<Integer> lld1 = new LinkedListDeque();
        ArrayDeque<Integer> lld2 = new ArrayDeque();

        for (int i = 0; i < 20; i++) {
            lld1.addFirst(i);
            lld2.addFirst(i);
        }

        assertEquals(lld1.removeLast(),lld2.removeLast());
        assertEquals(lld1.removeLast(),lld2.removeLast());
        assertEquals(lld1.removeLast(),lld2.removeLast());
    }
    @Test
    public void randomizedTest() {
        LinkedListDeque<Integer> L = new LinkedListDeque();
        ArrayDeque<Integer> B = new ArrayDeque();
        int N = 100000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                L.addFirst(randVal);
                B.addFirst(randVal);
                System.out.println("addFirst(" + randVal + ")");
            } else if (operationNumber == 2) {
                // size
                int x = L.size();
                System.out.println("sizeLinkedListDeque: " + x);
                int y = B.size();
                System.out.println("sizeArrayDeque: " + y);
                //assertEquals(L.size(), B.size());
            } else if (operationNumber == 3) {
                // get
                if (L.size() > 0) {
                    int x = L.get(0);
                    System.out.println("getFirstLinkedListDeque(" + x + ")");
                    int y = B.get(0);
                    System.out.println("getFirstArrayDeque(" + y + ")");
                    //assertEquals(L.get(0), B.get(0));
                }
            } else if (operationNumber == 4) {
                // removeFirst
                if (L.size() > 0) {
                    assertEquals(L.removeFirst(), B.removeFirst());
                }
            } else if (operationNumber == 5) {
                // removeLast
                if (L.size() > 0) {
                    int x = L.removeLast();
                    System.out.println("removeLastLinkedListDeque(" + x + ")");
                    int y = B.removeLast();
                    System.out.println("removeLastArrayDeque(" + y + ")");
                    //assertEquals(L.removeLast(), B.removeLast());
                    assertEquals(x, y);
                }
            }
        }
    }

}
