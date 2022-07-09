package deque;

public class DoublyLListDeque<TheForce> {

    public class d_node {

        public d_node prev;
        public TheForce item;
        public d_node next;


        public d_node() {
            prev = null;
            item = null;
            next = null;
        }


        public d_node( d_node p, TheForce i, d_node n) {
            prev = p;
            item = i;
            next = n;
        }

    }


    private d_node sentinel;
    private d_node indexgetter;
    private int size;

    /* Constructor that creates an empty linked list */
    DoublyLListDeque() {
        sentinel = null;
        sentinel = new d_node();
        size = 0;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size <= 0;
    }


    public void printDeque() {
        d_node p = sentinel;
        for (int i = 0; i < size ; i++) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }


    public void addFirst(TheForce i) {
        d_node new_node = new d_node(null, i, null);
        if (sentinel.next == null) {
            new_node.prev = new_node;
            sentinel.next = new_node;
            new_node.next = sentinel.next;
            sentinel.prev = new_node;

        } else {
            new_node.prev = sentinel.prev;
            sentinel.prev.next = new_node;
            sentinel.next.prev = new_node;
            new_node.next = sentinel.next;
            sentinel.next = new_node;

        }
        size += 1;
    }

    /* Adds an item to the back of the deque */
    public void addLast(TheForce i) {
        if (sentinel.next == null) {
            addFirst(i);
        } else {
            d_node new_node = new d_node(null, i, null);
            new_node.prev = sentinel.prev;
            sentinel.prev.next = new_node;
            sentinel.next.prev = new_node;
            new_node.next = sentinel.next;
            sentinel.prev = new_node;
            size += 1;
        }


    }


    public TheForce removeFirst() {
        d_node byenode = new d_node();
        byenode.next = sentinel.next;
        if (isEmpty()) {
            return null;
        } else {
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel.prev;
            sentinel.prev.next = sentinel.next;
            byenode.next.next = null;
            byenode.next.prev = null;
            size -= 1;
        }
        return byenode.item;
    }

    public TheForce removeLast() {
        d_node byenode = new d_node();
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
        return byenode.item;
    }


    public TheForce get(int index) {
        if (isEmpty()) {
            return null;
        } else if (index >= size) {
            return null;
        } else {
            d_node p = sentinel;
            for (int i = 0; i <= index; i++) {
                p = p.next;
            }
            return p.item;
        }
    }


    public TheForce getRecursive(int index) {
        d_node p = sentinel;
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

    private TheForce getRecursive(int index, d_node p) {
        if (index == 0) {
            return p.next.item;
        } else {
            p = p.next;
            return getRecursive(index - 1, p);
        }
    }


}
