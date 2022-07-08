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
            size = 0;
        }

        public d_node( d_node p, TheForce i, d_node n) {
            prev = p;
            item = i;
            next = n;
        }

    }

    private d_node sentinel;
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

    public TheForce getFirst() {
        return sentinel.next.item;
    }

//    public TheForce removeFirst() {
//        if (sentinel.item == null) {
//            return null;
//        } else {
//
//        }
//    }


    public static void main(String[] args) {
        DoublyLListDeque<Integer> test = new DoublyLListDeque<>();
        test.addFirst(9);
        test.addFirst(3);
        test.addFirst(0);
        System.out.println(test.getFirst());
        System.out.println(test.size());
    }

}
