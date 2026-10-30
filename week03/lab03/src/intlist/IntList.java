package intlist;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Replaces all instances of a with b in L.
     *  Modifies the passed list. Iterative (no recursion allowed). */
    public static void replaceID(IntList L, int a, int b) {
        IntList p = L;
        while (p != null) {
            if (p.first == a) {
                p.first = b;
            }
            p = p.rest;
        }
    }

    /** Returns a copy of L, but with all instances of a replaced by b.
     *  Does not modify the passed list. Recursive. */
    public static IntList replaceRND(IntList L, int a, int b) {
        if (L == null) {
            return null;
        }
        if (L.first == a) {
            return new IntList(b, replaceRND(L.rest, a, b));
        }
        return new IntList(L.first, replaceRND(L.rest, a, b));
    }

    /** Replaces all instances of a with b in L.
     *  Modifies the passed list. Recursive. */
    public static void replaceRD(IntList L, int a, int b) {
        if (L == null) {
            return;
        }
        if (L.first == a) {
            L.first = b;
        }
        replaceRD(L.rest, a, b);
    }

    /** The Boxes and Pointers exercise from the spec. Set a breakpoint on the
     *  first line, then step through in the Java Visualizer, predicting the
     *  picture before each step. (Careful: partway through, the lists briefly
     *  contain a cycle, so code that walks a list would loop forever.) */
    public static void main(String[] args) {
        IntList L1 = IntList.of(1, 2, 3);
        IntList L2 = new IntList(4, L1.rest);
        L2.rest.first = 13;
        L1.rest.rest.rest = L2;
        IntList L3 = IntList.of(50);
        L2.rest.rest = L3;
    }

    /* The methods below are used by the tests for this assignment.
       You do not need to read or understand them. */

    /** Returns a new IntList containing the given values.
     *  Example: IntList.of(1, 2, 3) is the list 1 -> 2 -> 3. */
    public static IntList of(int... values) {
        IntList L = null;
        for (int i = values.length - 1; i >= 0; i -= 1) {
            L = new IntList(values[i], L);
        }
        return L;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof IntList oL) {
            if (first != oL.first) {
                return false;
            } else if (rest == null && oL.rest == null) {
                return true;
            } else if (rest != null && oL.rest != null) {
                return rest.equals(oL.rest);
            }
        }
        return false;
    }
}
