import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;
import java.util.Formatter;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntListOptionalTests {
    /**
     * Returns an IntList of the given integers.
     */
    public static IntList of(int... nums) {
        IntList L = new IntList(nums[0], null);
        IntList current = L;
        for (int i = 1; i < nums.length; i++) {
            current.rest = new IntList(nums[i], null);
            current = current.rest;
        }
        return L;
    }

    /**
     * Returns true if two IntLists are equal.
     */
    public static boolean checkEquals(IntList L1, IntList L2) {
        if (L1 == null && L2 == null) {
            return true;
        }
        if (L1 == null || L2 == null) {
            return false;
        }
        if (L1.first != L2.first) {
            return false;
        }
        return checkEquals(L1.rest, L2.rest);
    }

    /**
     * If a cycle exists in the IntList, this method
     * returns an integer equal to the item number of the location where the
     * cycle is detected.
     */
    private int detectCycles(IntList A) {
        IntList tortoise = A;
        IntList hare = A;

        if (A == null)
            return 0;

        int cnt = 0;


        while (true) {
            cnt++;
            if (hare.rest != null)
                hare = hare.rest.rest;
            else
                return 0;

            tortoise = tortoise.rest;

            if (tortoise == null || hare == null)
                return 0;

            if (hare == tortoise)
                return cnt;
        }
    }

    /** Outputs the IntList as a String. You are not expected to read
     * or understand this method. */
    private String intListToString(IntList L) {
        if (L == null) {
            return "()";
        }

        Formatter out = new Formatter();
        String sep;
        sep = "(";
        int cycleLocation = detectCycles(L);
        int cnt = 0;

        for (IntList p = L; p != null; p = p.rest) {
            out.format("%s%d", sep, p.first);
            sep = ", ";

            cnt++;
            if ((cnt > cycleLocation) && (cycleLocation > 0)) {
                out.format("... (cycle exists) ...");
                break;
            }
        }
        out.format(")");
        return out.toString();
    }

    @Test
    @Order(1)
    @DisplayName("Test sum correctness")
    public void testSum() {
        IntList L = of(1, 2, 3);
        int expected = 6;
        int result = L.sum();

        if (expected != result) {
            fail("expected: " + expected + ", but got: " + result);
        }
    }

    @Test
    @Order(2)
    @DisplayName("Test addLast correctness")
    public void testAddLast() {
        IntList L = of(1, 2, 3);
        IntList expected = of(1, 2, 3, 4);
        L.addLast(4);

        if (!checkEquals(L, expected)) {
            String errorMessage = String.format("expected: %s, but got: %s", intListToString(expected), intListToString(L));
            fail(errorMessage);
        }
    }

    @Test
    @Order(3)
    @DisplayName("Test addFirst correctness")
    public void testAddFirst() {
        IntList L = of(1, 2, 3);
        IntList expected = of(4, 1, 2, 3);
        L.addFirst(4);

        if (!checkEquals(L, expected)) {
            String errorMessage = String.format("expected: %s, but got: %s", intListToString(expected), intListToString(L));
            fail(errorMessage);
        }
    }
}
