package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

//    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
//    public void addIsEmptySizeTest() {
//
//
//        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
//        ArrayDeque<String> arr_d = new ArrayDeque<>();
//
//		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
//        assertTrue("A newly initialized ADeque should be empty",  arr_d.isEmpty());
//		lld1.addFirst("front");
//        arr_d.addFirst("first");
//
//		// The && operator is the same as "and" in Python.
//		// It's a binary operator that returns true if both arguments true, and false otherwise.
//        assertEquals(1, lld1.size());
//        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());
//        assertEquals(1, arr_d.size());
//        assertFalse("arr_d should now contain 1 item", arr_d.isEmpty());
//
//
//        lld1.addLast("middle");
//        arr_d.addLast("second");
//		assertEquals(2, lld1.size());
//        assertEquals(2, arr_d.size());
//
//		lld1.addLast("back");
//        arr_d.addLast("last");
//		assertEquals(3, lld1.size());
//        assertEquals(3, arr_d.size());
//
//		System.out.println("Printing out Linked List deque: ");
//		lld1.printDeque();
//        System.out.println("Printing out Array List deque: ");
//        arr_d.printDeque();
//
//    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }

    @Test
    public void ArrayaddLastTest() {

        ArrayDeque<String> array_test = new ArrayDeque<>();

        array_test.addLast("a");
        array_test.addLast("b");
        array_test.addLast("c");

        assertEquals("a", array_test.get(5));
        assertEquals("c", array_test.get(7));
        assertEquals("c", array_test.removeLast());

        ArrayDeque<Integer> array_test2 = new ArrayDeque<>();

        for (int i = 0; i < 9; i++) {
            int opnumber = StdRandom.uniform(0, 2);
            if (opnumber == 0) {
                array_test2.addLast(i);
            } else {
                array_test2.addFirst(i);
            }
        }

    }


}
