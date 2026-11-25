public class StarTriangle5 {
    /**
     * Prints a right-aligned triangle of stars ('*') with 5 lines.
     * The first row contains 1 star, the second 2 stars, and so on.
     */
    public static void starTriangle5() {
        for (int i = 1; i <= 5; i++) {
            // Print 'spaces'
            for (int j = i; j < 5; j++) {
                IO.print(" ");
            }
            // Print '*'
            for (int j = 0; j < i; j++) {
                IO.print("*");
            }
            IO.println();
        }
    }

    void main() {
        starTriangle5();
    }
}
