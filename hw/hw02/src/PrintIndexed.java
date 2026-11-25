public class PrintIndexed {
    /**
     * Prints each character of a given string followed by the reverse of its index.
     * Example: printIndexed("hello") -> h4e3l2l1o0
     */
    public static void printIndexed(String s) {
        StringBuilder indexedStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            indexedStr.append(s.charAt(i));
            indexedStr.append(s.length() - 1 - i);
        }
        IO.println(indexedStr.toString());
    }

    void main() {
        printIndexed("hello");
        printIndexed("cat"); // should print c2a1t0
    }
}
