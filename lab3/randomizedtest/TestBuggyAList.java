package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> list1 = new AListNoResizing();
        BuggyAList<Integer> list2 = new BuggyAList();

        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);

        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);

        assertEquals(list1.removeLast(),list2.removeLast());
        assertEquals(list1.removeLast(),list2.removeLast());
        assertEquals(list1.removeLast(),list2.removeLast());

    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                //int size = L.size();
                //System.out.println("size: " + size);
                assertEquals(L.size(),B.size());
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() > 0){
                    //int x = L.getLast();
                    //System.out.println("getLast(" + x + ")");
                    assertEquals(L.getLast(),B.getLast());
                }
            } else if (operationNumber == 3) {
                // removeLast
                if (L.size() > 0) {
                    //int x = L.removeLast();
                    //System.out.println("removeLast(" + x + ")");
                    assertEquals(L.removeLast(),B.removeLast());
                }
            }

        }
    }
}
