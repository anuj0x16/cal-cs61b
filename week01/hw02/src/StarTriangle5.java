public class StarTriangle5 {
    /**
     * Prints a right-aligned triangle of stars ('*') with 5 lines.
     * The first row contains 1 star, the second 2 stars, and so on.
     */
    public static void starTriangle5() {
        for (int i = 0; i < 5; i++) {
            for (int j = 4; j > i; j--) {
                IO.print(" ");
            }
            for (int k = 1; k <= i + 1; k++) {
                IO.print("*");
            }
            IO.println();
        }
    }

    void main() {
        starTriangle5();
    }
}
