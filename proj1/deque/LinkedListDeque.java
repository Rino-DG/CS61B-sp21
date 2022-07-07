package deque;

public class LinkedListDeque<ChosenOne> {
    // Add and Remove operations must not involve looping or recursion
    // Get must use iteration, not recursion
    // Do not maintain references to items that are no longer in the deque

    // 10 Methods to implement
    // Dont forget to implement 2 more methods
        // LinkedListDeque(): Creates an empty linked list deque
        // getRecursive(int index): Same as get, but uses recursion

    // Implement Circular sentinel topology

    // Nesting the IntNode class

    // Experimenting with SLL
    // The first item (if it exists) is at sentinel.next


    public class StuffNode {
        public StuffNode prev;
        public ChosenOne item;
        public StuffNode next;

        public StuffNode(ChosenOne x, StuffNode n) {
            item = x;
            next = n;
        }
    }

    public StuffNode sentinel;
    private int size;

    // Constructor that creates an empty list
    public LinkedListDeque() {
        sentinel = new StuffNode(null, null);
        size = 0;
    }

    // Constructor that creates a node with int x as the item, and null as the next.
    public LinkedListDeque(ChosenOne x) {
        sentinel = new StuffNode(x, null);
        size = 1;
    }

    // Adds an item to the front of the list
    public void addFirst(ChosenOne x) {
        sentinel.next = new StuffNode(x, sentinel.next);
        size += 1;
    }

    // Returns the first item of the list
    public ChosenOne getFirst() {
        return sentinel.item;
    }

    // Add an item to the end of the list
    public void addLast(ChosenOne x) {
        size += 1;

        StuffNode p = sentinel;

        // Move p until it reaches the end of the list
        while (p.next != null) {
            p = p.next;
        }

        p.next = new StuffNode(x, null);
    }


    public int size() {
        return size;
    }


    public static void main(String[] args) {
        LinkedListDeque<String> newlist = new LinkedListDeque<>();
//        newlist.addFirst(2);
//        newlist.addFirst(3);
//        System.out.println(newlist.getFirst());
//        System.out.println(newlist.size());
        newlist.addLast("Bruh");
        System.out.println(newlist.size());
    }


}
