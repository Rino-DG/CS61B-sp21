package deque;

import org.junit.Test;

import java.lang.reflect.Array;
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




}
