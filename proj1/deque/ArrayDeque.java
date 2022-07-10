package deque;

public class ArrayDeque<Item> {

    private Item[] items;
    private int size;
    private int REFACTOR = 2;
    private int nextFirst = 4;
    private int nextLast = 5;


    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i]);
        }
    }

    public Item get(int index) {
        if (isEmpty()) {
            return null;
        } else if ( index > items.length ) {
            return null;
        } else {
            return items[index];
        }
    }




    /* Adds to the last index of the array */
//    private void resize(int capacity) {
//        Item[] a = (Item[]) new Object[capacity];
//        System.arraycopy(items, 0, a,size,  size);
//        items = a;
//    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
//        if (size == items.length) {
//            resize(size * REFACTOR);
//        }
        items[nextLast] = x;
        movenextLast();
        size += 1;
    }

    public void addFirst(Item x) {
        items[nextFirst] = x;
        movenextFirst();
        size += 1;
    }

    public void movenextLast() {
        if ( nextLast == items.length - 1 && items[0] == null) {
            nextLast = -1;
        }
        nextLast += 1;
    }

    public void movenextFirst() {
        if ( nextFirst == -1 && items[7] == null) {
            nextFirst = size;
        }
        nextFirst -= 1;
    }


    public Item removeLast() {
        Item x = getLast();

        if (nextLast == 0) {
            items[items.length - 1] = null;
        } else {
            items[nextLast - 1] = null;
        }
        size -= 1;
        return x;
    }

    public Item removeFirst() {
        Item x = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        return x;
    }

    private Item getLast() {
        if (nextLast == 0) {
            return items[items.length - 1];
        } else {
            return items[nextLast - 1];
        }

    }



}
