package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    public class Dnode {

        private Dnode prev;
        private T item;
        private Dnode next;


        public Dnode() {
            prev = null;
            item = null;
            next = null;
        }


        public Dnode(Dnode p, T i, Dnode n) {
            prev = p;
            item = i;
            next = n;
        }

    }


    private Dnode sentinel;
    private int size;

    /* Constructor that creates an empty linked list */
    public LinkedListDeque() {
        sentinel = null;
        sentinel = new Dnode();
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
        Dnode newNode = new Dnode(null, i, null);
        if (sentinel.next == null) {
            newNode.prev = newNode;
            sentinel.next = newNode;
            newNode.next = sentinel.next;
            sentinel.prev = newNode;

        } else {
            newNode.prev = sentinel.prev;
            sentinel.prev.next = newNode;
            sentinel.next.prev = newNode;
            newNode.next = sentinel.next;
            sentinel.next = newNode;

        }
        size += 1;
    }

    @Override
    /* Adds an item to the back of the deque */
    public void addLast(T i) {
        if (sentinel.next == null) {
            addFirst(i);
        } else {
            Dnode newNode = new Dnode(null, i, null);
            newNode.prev = sentinel.prev;
            sentinel.prev.next = newNode;
            sentinel.next.prev = newNode;
            newNode.next = sentinel.next;
            sentinel.prev = newNode;
            size += 1;
        }

    }

    @Override
    public T removeFirst() {
        Dnode byenode = new Dnode();
        byenode.next = sentinel.next;
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            sentinel.next = null;
            sentinel.prev = null;
            size -= 1;
        } else {
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel.prev;
            sentinel.prev.next = sentinel.next;
            byenode.next.next = null;
            byenode.next.prev = null;
            size -= 1;
        }
        return byenode.next.item;
    }

    @Override
    public T removeLast() {
        Dnode byenode = new Dnode();
        byenode.next = sentinel.prev;
        if (isEmpty()) {
            return null;
        } else {
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel.next;
            sentinel.next.prev = sentinel.prev;
            byenode.next.next = null;
            byenode.next.prev = null;
            size -= 1;
        }
        return byenode.next.item;
    }

    @Override
    public T get(int index) {
        if (isEmpty()) {
            return null;
        } else if (index >= size) {
            return null;
        } else {
            Dnode p = sentinel;
            for (int i = 0; i <= index; i++) {
                p = p.next;
            }
            return p.item;
        }
    }


    public T getRecursive(int index) {
        Dnode p = sentinel;
        if (isEmpty()) {
            return null;
        } else if (index >= size) {
            return null;
        } else if (index == 0) {
            return p.next.item;
        }
        p = p.next;
        return getRecursive(index - 1, p);
    }

    private T getRecursive(int index, Dnode p) {
        if (index == 0) {
            return p.next.item;
        } else {
            p = p.next;
            return getRecursive(index - 1, p);
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {

        private Dnode wizNode = new Dnode();
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
