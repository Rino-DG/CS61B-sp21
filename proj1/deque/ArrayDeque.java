package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T>  {

    private T[] items;
    private int size;
    private int REFACTOR = 2;
    private int nextFirst = 0;
    private int nextLast = 2;
    private int startingIndex = 1;
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
            int index = (startingIndex + i) % capacity;
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
        int actIndex = (startingIndex + index) % capacity;
        return items[actIndex];
    }


    /** Inserts X into the back of the list. */
    @Override
    public void addLast(T x) {
        if (isEmpty()) {
            items[startingIndex] = x;
            size += 1;
        } else {
            items[nextLast] = x;
            size += 1;
            if (size == capacity) {
                resizeL(size * REFACTOR);
            }
            adjustNL();
        }

    }

    private void adjustNL() {
        nextLast = (startingIndex + size) % capacity;
    }



    @Override
    public void addFirst(T x) {
        if (isEmpty()) {
            items[startingIndex] = x;
            size += 1;
        } else {
            items[nextFirst] = x;
            size += 1;
            if (size == capacity) {
                nextLast = capacity;
                resizeF(size * REFACTOR);
            }
            adjustNF();
        }

    }

    private void resizeF(int newcapacity) {
        T[] a = (T[]) new Object[newcapacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
        capacity = newcapacity;
        nextFirst = newcapacity - 1;
        startingIndex = 1;
    }

    private void resizeL(int newcapacity) {
        T[] a = (T[]) new Object[newcapacity];
        int k = startingIndex;
        for (int i = 0; i < size; i++) {
            a[i] = items[k];
            k = (k + 1) % items.length;
        }
        items = a;
        startingIndex = 0;
        nextFirst = newcapacity - 1;
        capacity = newcapacity;

    }


    private void sizedown() {
        if (isEmpty()) {
            capacity = 8;
            items = (T[]) new Object[capacity];
            nextFirst = size;
        } else if (items.length / 4 > size && size >= 4) {
            resizeL(size * 2);
        }
    }

    private void adjustNF() {
        nextFirst--;
        startingIndex--;
        if (nextFirst == -1) {
            nextFirst = capacity - 1;
        } else if (startingIndex == -1) {
            startingIndex = capacity - 1;
        }
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        /* Get the last ITEM and the INDEX of the item */
        T x = getLast();
        int lastIndex = getLastIndex();

        /* Delete the last ITEM and decrement the size */
        items[lastIndex] = null;
        size = size - 1;

        nextLast--;
        sizedown();

        return x;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        /* Get the first ITEM and the INDEX of the item */
        T x = getFirst();

        /* Delete the first ITEM and decrement the size */
        items[startingIndex] = null;
        incNF();
        size = size - 1;

        sizedown();

        return x;
    }



    private void incNF() {
        nextFirst++;
        startingIndex++;
        if (nextFirst == 8) {
            nextFirst = 0;
        } else if (startingIndex == 8) {
            startingIndex = 0;
        }
    }


    private T getLast() {
        return items[(startingIndex + size - 1) % capacity];
    }

    private T getFirst() {
        return items[startingIndex];
    }

    private int getLastIndex() {
        return (startingIndex + size - 1) % capacity;
    }


    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;
        ArrayDequeIterator() {
            wizPos = 0;
        }
        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnitem = get(wizPos);
            wizPos += 1;
            return returnitem;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof ArrayDeque)) {
            return false;
        }
        ArrayDeque<?> ad = (ArrayDeque<?>) o;
        if (ad.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (ad.get(i) != get(i)) {
                return false;
            }
        }
        return true;
    }


}
