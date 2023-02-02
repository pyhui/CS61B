package deque;

import java.util.Comparator;

/**
 * A MaxArrayDeque has all of the methods that an ArrayDeque has,
 * but it also has 2 additional methods and a new constructor.
 */
public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> maxArrayDequeComparator;
    public MaxArrayDeque(Comparator<T> c) {
        maxArrayDequeComparator = c;
    }

    public T max() {
        return max(maxArrayDequeComparator);
    }

    public T max(Comparator<T> c) {
        if (size() == 0) {
            return null;
        }
        T maxItem = this.get(0);
        for (int i = 0; i < size(); i++) {
            if (c.compare(maxItem, this.get(i)) < 0) {
                maxItem = this.get(i);
            }
        }
        return maxItem;
    }
}
