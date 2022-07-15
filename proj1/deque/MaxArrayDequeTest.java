package deque;

import org.junit.Test;

import java.util.Comparator;

public class MaxArrayDequeTest {

    @Test
    public void constructortest() {
        MaxArrayDeque<Integer> MADTest = new MaxArrayDeque<>(new IntComparator());

        MADTest.addFirst(5);
        MADTest.addLast(8);
        MADTest.addFirst(0);
        MADTest.addLast(42);

       System.out.println(MADTest.max());
    }


    private static class IntComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i1 - i2;
        }
    }
}
