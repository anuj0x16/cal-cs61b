public class PrintIndexed {
    /**
     * Prints each character of a given string followed by the reverse of its index.
     * Example: printIndexed("hello") -> h4e3l2l1o0
     */
    public static void printIndexed(String s) {
        StringBuilder indexedStr = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            indexedStr.append(s.charAt(s.length() - i - 1));
            indexedStr.append(i);
        }
        IO.println(indexedStr.toString());
    }

    void main() {
        printIndexed("hello");
        printIndexed("cat"); // should print c2a1t0
    }
}
