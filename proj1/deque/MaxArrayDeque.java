package deque;

import org.junit.Test;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();  // that call the parent constructor to initialize the deque
        comparator = c;
    }

    /**
     * return the max depend on the initial comparitor
     *
     * @return
     */
    public T max() {
        if (isEmpty()) return null;
        T max = get(0);
        for (int i = 1; i < size(); i++) {
            if (comparator.compare(get(i), max) > 0) {
                max = get(i);
            }
        }
        return max;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) return null;
        T max = get(0);
        Comparator last = comparator;
        comparator = c;
        for (int i = 1; i < size(); i++) {
            if (comparator.compare(get(i), max) > 0) {
                max = get(i);
            }
        }
        comparator = last;
        return max;
    }

}