package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    private class Dnode {

        private T item;
        private Dnode prev;
        private Dnode next;


        public Dnode(T i, Dnode p, Dnode n) {
            item = i;
            prev = p;
            next = n;
        }

    }


    private Dnode sentinel = new Dnode(null, null, null);
    private int size;

    /* Constructor that creates an empty linked list */
    public LinkedListDeque() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }



    @Override
    public void printDeque() {
        Dnode p = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public void addFirst(T i) {
        sentinel.next = new Dnode(i, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    @Override
    /* Adds an item to the back of the deque */
    public void addLast(T i) {
        sentinel.prev = new Dnode(i, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return item;

    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        Dnode currentNode = sentinel.next;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return currentNode.item;
            }
            currentNode = currentNode.next;
        }
        throw new AssertionError();
    }

    public T getRecursive(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, Dnode currentNode) {
        if (index == 0) {
            return currentNode.item;
        }
        return getRecursiveHelper(index - 1, currentNode.next);
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {

        private Dnode wizNode;
        LinkedListDequeIterator() {
            wizNode = sentinel;
        }

        int i = 0;
        public boolean hasNext() {
            return i < size;
        }

        public T next() {
            wizNode = wizNode.next;
            i += 1;
            return wizNode.item;
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
        if (!(o instanceof LinkedListDeque)) {
            return false;
        }
        LinkedListDeque<?> lld = (LinkedListDeque<?>) o;
        if (lld.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (lld.get(i) != get(i)) {
                return false;
            }
        }
        return true;
    }
}
