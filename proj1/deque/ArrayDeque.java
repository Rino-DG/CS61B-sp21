package deque;

public class ArrayDeque<T> implements Deque<T> {

    private T[] items;
    private int size;
    private int REFACTOR = 2;
    private int nextFirst = 0;
    private int nextLast = 2;
    private int starting_index = 1;
    private int capacity = 8;


    public ArrayDeque() {
        items = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }



    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            int index = (starting_index + i) % capacity;
            System.out.print(items[index]);
        }
        System.out.println();
    }

    @Override
    public T get(int index) {
        /* If the item does not exist, return null*/
        if (index >= size) {
            return null;
        }
        int act_index = (starting_index + index) % capacity;
        return items[act_index];
    }




    /* Adds to the last index of the array */
//    private void resize(int capacity) {
//        Item[] a = (Item[]) new Object[capacity];
//        System.arraycopy(items, 0, a,size,  size);
//        items = a;
//    }


    /** Inserts X into the back of the list. */
    @Override
    public void addLast(T x) {
        if (isEmpty()) {
            items[starting_index] = x;
            size += 1;
        } else {
            items[nextLast] = x;
            size += 1;
            adjust_nL();
        }

    }

    private void adjust_nL() {
        nextLast = (starting_index + size) % capacity;
    }


    @Override
    public void addFirst(T x) {
        if (isEmpty()) {
            items[starting_index] = x;
            size += 1;
        } else {
            items[nextFirst] = x;
            size += 1;
            adjust_nF();
        }

    }

    private void adjust_nF() {
        nextFirst--;
        starting_index --;
        if (nextFirst == -1) {
            nextFirst = capacity - 1;
        } else if (starting_index == -1) {
            starting_index = capacity - 1;
        }
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        /* Get the last ITEM and the INDEX of the item */
        T x = getLast();
        int last_index = getLastIndex();

        /* Delete the last ITEM and decrement the size */
        items[last_index] = null;
        size = size - 1;

        return x;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }
        /* Get the first ITEM and the INDEX of the item */
        T x = getFirst();

        /* Delete the first ITEM and decrement the size */
        items[starting_index] = null;
        inc_nF();
        size = size - 1;


        return x;
    }

    private void resize() {

    }

    private void inc_nF() {
        nextFirst++;
        starting_index ++;
        if (nextFirst == 8) {
            nextFirst = 0;
        } else if (starting_index == 8) {
            starting_index = 0;
        }
    }


    private T getLast() {
        return items[(starting_index + size - 1) % capacity];
    }

    private T getFirst() {
        return items[starting_index];
    }

    private int getLastIndex() {
        return (starting_index + size - 1) % capacity;
    }



}
