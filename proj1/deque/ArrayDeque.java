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


    /** Inserts X into the back of the list. */
    @Override
    public void addLast(T x) {
        if (isEmpty()) {
            items[starting_index] = x;
            size += 1;
        } else {
            items[nextLast] = x;
            size += 1;
            if (size == capacity) {
                resizeL(size * REFACTOR);
            }
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
            if (size == capacity) {
                nextLast = capacity;
                resizeF(size * REFACTOR);
            }
            adjust_nF();
        }

    }

    private void resizeF(int newcapacity) {
        T[] a = (T[]) new Object[newcapacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
        capacity = newcapacity;
        nextFirst = newcapacity - 1;
        starting_index = 1;
    }

    private void resizeL(int newcapacity) {
        T[] a = (T[]) new Object[newcapacity];
        int k = starting_index;
        for (int i = 0; i < size; i++) {
            a[i] = items[k];
            k = (k + 1) % items.length;
        }
        items = a;
        starting_index = 0;
        nextFirst = newcapacity - 1;
        capacity = newcapacity;

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
