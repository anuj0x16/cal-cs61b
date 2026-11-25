public class StarTriangleN {
    /**
     * Prints a right-aligned triangle of stars ('*') with N lines.
     * The first row contains 1 star, the second 2 stars, and so on.
     */
    public static void starTriangle(int N) {
        for (int i = 1; i <= N; i++) {
            printChar(N - i, ' ');  // Print leading spaces
            printChar(i, '*');            // Print stars
            IO.println();
        }
    }

    public static void printChar(int count, char ch) {
        for (int i = 0; i < count; i++) {
            IO.print(ch);
        }
    }

    void main() {
        starTriangle(6);
    }
}
