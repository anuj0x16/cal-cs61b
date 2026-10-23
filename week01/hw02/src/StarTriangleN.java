public class StarTriangleN {
    /**
     * Prints a right-aligned triangle of stars ('*') with N lines.
     * The first row contains 1 star, the second 2 stars, and so on.
     */
    public static void starTriangle(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = N-1; j > i; j--) {
                IO.print(" ");
            }
            for (int k = 1; k <= i + 1; k++) {
                IO.print("*");
            }
            IO.println();
        }
    }

    void main() {
        starTriangle(7);
    }
}
