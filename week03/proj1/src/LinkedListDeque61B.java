import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    private class Node {
        T item;
        Node next;
        Node prev;

        Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }

        T getRecursive(int index) {
            if (index == 0) {
                return item;
            }
            return next.getRecursive(index - 1);
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        size = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    void main(String[] args) {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(0);   // [0]
        lld.addLast(1);   // [0, 1]
        lld.addFirst(-1); // [-1, 0, 1]
    }

    /**
     * Add {@code x} to the front of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        Node n = new Node(x, sentinel.next, sentinel);
        sentinel.next.prev = n;
        sentinel.next = n;
        size++;
    }

    /**
     * Add {@code x} to the back of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        Node n = new Node(x, sentinel, sentinel.prev);
        sentinel.prev.next = n;
        sentinel.prev = n;
        size++;
    }

    /**
     * Returns a List copy of the deque. Does not alter the deque.
     *
     * @return a new list copy of the deque.
     */
    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node p = sentinel.next;
        while (p != sentinel) {
            returnList.add(p.item);
            p = p.next;
        }
        return returnList;
    }

    /**
     * Returns if the deque is empty. Does not alter the deque.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the size of the deque. Does not alter the deque.
     *
     * @return the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Return the element at the front of the deque, if it exists.
     *
     * @return element, otherwise {@code null}.
     */
    @Override
    public T getFirst() {
        return sentinel.next.item;
    }

    /**
     * Return the element at the back of the deque, if it exists.
     *
     * @return element, otherwise {@code null}.
     */
    @Override
    public T getLast() {
        return sentinel.prev.item;
    }

    /**
     * Remove and return the element at the front of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeFirst() {
        Node n = sentinel.next;
        sentinel.next = n.next;
        n.next.prev = sentinel;
        size = (size > 0) ? size - 1 : 0;
        return n.item;
    }

    /**
     * Remove and return the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeLast() {
        Node n = sentinel.prev;
        sentinel.prev = n.prev;
        n.prev.next = sentinel;
        size = (size > 0) ? size - 1 : 0;;
        return n.item;
    }

    /**
     * The Deque61B abstract data type does not typically have a get method,
     * but we've included this extra operation to provide you with some
     * extra programming practice. Gets the element, iteratively. Returns
     * null if index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node p = sentinel.next;
        while (index > 0 && p != sentinel) {
            p = p.next;
            index--;
        }
        return p.item;
    }

    /**
     * This method technically shouldn't be in the interface, but it's here
     * to make testing nice. Gets an element, recursively. Returns null if
     * index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return sentinel.next.getRecursive(index);
    }
}
