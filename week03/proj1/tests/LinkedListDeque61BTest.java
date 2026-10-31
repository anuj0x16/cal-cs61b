import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/** Performs some basic linked list tests. */
public class LinkedListDeque61BTest {

    /* ---------------------------- add tests ---------------------------- */

    @Test
    @DisplayName("add_first_from_empty")
    public void addFirstFromEmpty() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        assertThat(lld.toList()).containsExactly(1).inOrder();
    }

    @Test
    @DisplayName("add_last_from_empty")
    public void addLastFromEmpty() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        assertThat(lld.toList()).containsExactly(1).inOrder();
    }

    @Test
    @DisplayName("add_first_nonempty")
    public void addFirstNonempty() {
        Deque61B<String> lld = new LinkedListDeque61B<>();
        lld.addFirst("back");
        lld.addFirst("middle");
        lld.addFirst("front");
        assertThat(lld.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    @DisplayName("add_last_nonempty")
    public void addLastNonempty() {
        Deque61B<String> lld = new LinkedListDeque61B<>();
        lld.addLast("front");
        lld.addLast("middle");
        lld.addLast("back");
        assertThat(lld.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    /* --------------------------- toList tests -------------------------- */

    @Test
    @DisplayName("to_list_empty")
    public void toListEmpty() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.toList()).isEmpty();
    }

    @Test
    @DisplayName("to_list_nonempty")
    public void toListNonempty() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addFirst(0);
        assertThat(lld.toList()).containsExactly(0, 1, 2).inOrder();
    }

    /* ---------------------- add after remove tests --------------------- */

    @Test
    @DisplayName("add_first_after_remove_to_empty")
    public void addFirstAfterRemoveToEmpty() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.removeFirst();
        lld.removeFirst();
        lld.removeFirst();
        assertThat(lld.toList()).isEmpty();

        lld.addFirst(10);
        lld.addFirst(20);
        assertThat(lld.toList()).containsExactly(20, 10).inOrder();
    }

    @Test
    @DisplayName("add_last_after_remove_to_empty")
    public void addLastAfterRemoveToEmpty() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.removeLast();
        lld.removeLast();
        lld.removeLast();
        assertThat(lld.toList()).isEmpty();

        lld.addLast(10);
        lld.addLast(20);
        assertThat(lld.toList()).containsExactly(10, 20).inOrder();
    }

    /* ---------------------------- remove tests ------------------------- */

    @Test
    @DisplayName("remove_first")
    public void removeFirst() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.addLast(4);

        assertThat(lld.removeFirst()).isEqualTo(1);
        assertThat(lld.toList()).containsExactly(2, 3, 4).inOrder();
    }

    @Test
    @DisplayName("remove_last")
    public void removeLast() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.addLast(4);

        assertThat(lld.removeLast()).isEqualTo(4);
        assertThat(lld.toList()).containsExactly(1, 2, 3).inOrder();
    }

    @Test
    @DisplayName("remove_first_to_empty")
    public void removeFirstToEmpty() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);

        // Remove all but one.
        assertThat(lld.removeFirst()).isEqualTo(1);
        assertThat(lld.removeFirst()).isEqualTo(2);
        assertThat(lld.toList()).containsExactly(3).inOrder();

        // Remove the last remaining element -> empty.
        assertThat(lld.removeFirst()).isEqualTo(3);
        assertThat(lld.toList()).isEmpty();
    }

    @Test
    @DisplayName("remove_last_to_empty")
    public void removeLastToEmpty() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);

        // Remove all but one.
        assertThat(lld.removeLast()).isEqualTo(3);
        assertThat(lld.removeLast()).isEqualTo(2);
        assertThat(lld.toList()).containsExactly(1).inOrder();

        // Remove the last remaining element -> empty.
        assertThat(lld.removeLast()).isEqualTo(1);
        assertThat(lld.toList()).isEmpty();
    }

    @Test
    @DisplayName("remove_first_to_one")
    public void removeFirstToOne() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.addLast(4);

        // Remove all but two.
        assertThat(lld.removeFirst()).isEqualTo(1);
        assertThat(lld.removeFirst()).isEqualTo(2);
        assertThat(lld.toList()).containsExactly(3, 4).inOrder();

        // One more removal -> one element left.
        assertThat(lld.removeFirst()).isEqualTo(3);
        assertThat(lld.toList()).containsExactly(4).inOrder();
    }

    @Test
    @DisplayName("remove_last_to_one")
    public void removeLastToOne() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.addLast(4);

        // Remove all but two.
        assertThat(lld.removeLast()).isEqualTo(4);
        assertThat(lld.removeLast()).isEqualTo(3);
        assertThat(lld.toList()).containsExactly(1, 2).inOrder();

        // One more removal -> one element left.
        assertThat(lld.removeLast()).isEqualTo(2);
        assertThat(lld.toList()).containsExactly(1).inOrder();
    }

    /* ----------------------------- get tests --------------------------- */

    @Test
    @DisplayName("get_first_empty")
    public void getFirstEmpty() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.getFirst()).isNull();
    }

    @Test
    @DisplayName("get_last_empty")
    public void getLastEmpty() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.getLast()).isNull();
    }

    @Test
    @DisplayName("get_first_valid")
    public void getFirstValid() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        assertThat(lld.getFirst()).isEqualTo(1);
        // getFirst must not alter the deque.
        assertThat(lld.toList()).containsExactly(1, 2, 3).inOrder();
    }

    @Test
    @DisplayName("get_last_valid")
    public void getLastValid() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        assertThat(lld.getLast()).isEqualTo(3);
        // getLast must not alter the deque.
        assertThat(lld.toList()).containsExactly(1, 2, 3).inOrder();
    }

    @Test
    @DisplayName("get_valid")
    public void getValid() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(10);
        lld.addLast(20);
        lld.addLast(30);
        assertThat(lld.get(0)).isEqualTo(10);
        assertThat(lld.get(1)).isEqualTo(20);
        assertThat(lld.get(2)).isEqualTo(30);
    }

    @Test
    @DisplayName("get_oob_large")
    public void getOobLarge() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(10);
        lld.addLast(20);
        lld.addLast(30);
        assertThat(lld.get(3)).isNull();
        assertThat(lld.get(100)).isNull();
    }

    @Test
    @DisplayName("get_oob_neg")
    public void getOobNeg() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(10);
        lld.addLast(20);
        lld.addLast(30);
        assertThat(lld.get(-1)).isNull();
        assertThat(lld.get(-100)).isNull();
    }

    @Test
    @DisplayName("get_recursive_valid")
    public void getRecursiveValid() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(10);
        lld.addLast(20);
        lld.addLast(30);
        assertThat(lld.getRecursive(0)).isEqualTo(10);
        assertThat(lld.getRecursive(1)).isEqualTo(20);
        assertThat(lld.getRecursive(2)).isEqualTo(30);
    }

    @Test
    @DisplayName("get_recursive_oob_large")
    public void getRecursiveOobLarge() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(10);
        lld.addLast(20);
        lld.addLast(30);
        assertThat(lld.getRecursive(3)).isNull();
        assertThat(lld.getRecursive(100)).isNull();
    }

    @Test
    @DisplayName("get_recursive_oob_neg")
    public void getRecursiveOobNeg() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(10);
        lld.addLast(20);
        lld.addLast(30);
        assertThat(lld.getRecursive(-1)).isNull();
        assertThat(lld.getRecursive(-100)).isNull();
    }

    /* ---------------------------- size tests --------------------------- */

    @Test
    @DisplayName("size")
    public void size() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.size()).isEqualTo(0);
        lld.addFirst(1);
        assertThat(lld.size()).isEqualTo(1);
        lld.addLast(2);
        lld.addFirst(0);
        assertThat(lld.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("size_after_remove_to_empty")
    public void sizeAfterRemoveToEmpty() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.removeFirst();
        lld.removeLast();
        lld.removeFirst();
        assertThat(lld.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("size_after_remove_from_empty")
    public void sizeAfterRemoveFromEmpty() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.removeFirst()).isNull();
        assertThat(lld.removeLast()).isNull();
        // Size must not go negative.
        assertThat(lld.size()).isEqualTo(0);
    }

    /* --------------------------- isEmpty tests ------------------------- */

    @Test
    @DisplayName("is_empty_true")
    public void isEmptyTrue() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("is_empty_false")
    public void isEmptyFalse() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        assertThat(lld.isEmpty()).isFalse();
    }
}
