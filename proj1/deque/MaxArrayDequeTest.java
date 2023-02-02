package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;

public class MaxArrayDequeTest {
    public static class IntComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return a - b;
        }
    }
    public static class StringComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    }
    public static class StringLengthComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    }
    @Test
    /* Test the max method of the MaxArrayDeque . */
    public void MaxTest() {
        MaxArrayDeque<Integer> array1 = new MaxArrayDeque(new IntComparator());
        for (int i = 0; i < 10; i++) {
            array1.addFirst(i);
        }
        assertEquals(9,array1.max().intValue());
    }

    @Test
    /* Test the max method that hava a parameter Comparator c of the MaxArrayDeque . */
    public void MaxComparatorTest() {
        MaxArrayDeque<String> array1 = new MaxArrayDeque(new StringComparator());
        array1.addFirst("have");
        array1.addFirst("has");
        array1.addFirst("had");
        array1.addFirst("having");
        assertEquals("having", array1.max(new StringLengthComparator()));
    }
}




