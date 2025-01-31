package deque;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import edu.princeton.cs.algs4.StdRandom;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Random;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    Random rand = new Random();

    @Test
    /* Test for the get Item method of ArrayDeque */
    public void getItemTest() {

        ArrayDeque<String> getItem_t1 = new ArrayDeque<>();
        // Testing null
        for (int i = 0; i < 100; i++) {
            int n = rand.nextInt(30);
            assertNull(getItem_t1.get(n));
        }
    }

    @Test
    public void addLastTest() {
        ArrayDeque<String> addLast_t1 = new ArrayDeque<>();

        // Testing if it adds to index 0 if the size is 0
        addLast_t1.addLast("A");
        assertEquals("A", addLast_t1.get(0));
        assertEquals(1, addLast_t1.size());


        // Testing if it adds to index 1 if the size is 1;
        addLast_t1.addLast("B");
        assertEquals("B", addLast_t1.get(1));
        assertEquals(2, addLast_t1.size());
        addLast_t1.printDeque();


        // Testing last index after 8 items are added;
        addLast_t1.addLast("C");
        addLast_t1.addLast("D");
        addLast_t1.addLast("E");
        addLast_t1.addLast("F");
        addLast_t1.addLast("G");
        addLast_t1.addLast("H");
        assertEquals("H", addLast_t1.get(7));
        assertEquals(8, addLast_t1.size());
        addLast_t1.printDeque();

    }

    @Test
    public void removeLastTest() {
        ArrayDeque<Integer> remLast_t1 = new ArrayDeque<>();
        int size = 0;
        for (int i = 0; i < 9; i++) {
            int n = rand.nextInt(2);
            if ( n == 0 ) {
                remLast_t1.addLast(i);
                size += 1;
                assertEquals(size, remLast_t1.size());
            } else {
                if (remLast_t1.size() == 0) {
                    size = 0;
                } else {
                    size -= 1;
                    remLast_t1.removeLast();
                    assertEquals(size, remLast_t1.size());
                }
            }
        }


    }


    @Test
    public void addFirstTest() {
        ArrayDeque<String> addFirst_t1 = new ArrayDeque<>();

        addFirst_t1.addFirst("A");
        assertEquals("A", addFirst_t1.get(0));
        assertEquals(1, addFirst_t1.size());

        addFirst_t1.addFirst("B");
        addFirst_t1.addFirst("C");
        assertEquals("A", addFirst_t1.get(2));
        assertEquals(3, addFirst_t1.size());
        addFirst_t1.printDeque();

    }


    @Test
    public void remFirstTest() {
        ArrayDeque<String> t1_remFirst = new ArrayDeque<>();

        t1_remFirst.addFirst("A");
        t1_remFirst.addFirst("B");
        t1_remFirst.addLast("C");
        t1_remFirst.addFirst("D");
        t1_remFirst.printDeque();
        t1_remFirst.removeFirst();
        t1_remFirst.printDeque();
    }


    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> rtArray = new ArrayDeque<>();

        int N = 5000;
        int arraysize = 0;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                rtArray.addLast(randVal);
                arraysize += 1;
            } else if (operationNumber == 1) {
                // size
                assertEquals(arraysize, rtArray.size());

            } else if (operationNumber == 2) {
                // getLast and RemoveLast
                if (rtArray.size() > 0) {
                    rtArray.removeLast();
                    arraysize -= 1;
                }
            }
        }

    }

    @Test
    public void resizeTest() {
        ArrayDeque<Integer> rTArray = new ArrayDeque<>();

        for (int i = 0; i < 7; i++) {
            rTArray.addFirst(i);
        }
        for (int i = 7; i < 11; i++) {
            rTArray.addLast(i);
        }
        rTArray.addFirst(69);
        System.out.println(rTArray.get(0));
    }

    @Test
    public void iteratorTest() {

        ArrayDeque<Integer> iTArray = new ArrayDeque<>();

        iTArray.addFirst(0);
        iTArray.addLast(10);
        iTArray.addLast(30);

        for (int item: iTArray) {
            System.out.println(item);
        }
    }

    @Test
    public void sizedownTest() {

        ArrayDeque<Integer> sdArray = new ArrayDeque<>();


        for (int i = 0; i < 17; i ++) {
            sdArray.addLast(i);
        }

        for (int i = 0; i < 17; i ++) {
            sdArray.removeLast();
        }

        assertEquals(0, sdArray.size());
    }

    @Test
    public void addWithResizingTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < 20; i++) {
            arrayDeque.addLast(i);
        }

        assertEquals("Should have size 20", 20, arrayDeque.size());
    }
}
