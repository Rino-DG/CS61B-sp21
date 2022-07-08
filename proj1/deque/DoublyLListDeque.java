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
    private int size;

    /* Constructor that creates an empty linked list */
    DoublyLListDeque() {
        sentinel = new d_node(null, null, null);
        size = 0;
    }

    DoublyLListDeque(TheForce i) {
        sentinel =
        size = 1;
    }


    public static void main(String[] args) {
        DoublyLListDeque<Integer> test = new DoublyLListDeque<>(5);

    }

}
