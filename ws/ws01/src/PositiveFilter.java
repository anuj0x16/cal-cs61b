import java.util.List;

public class PositiveFilter {
    /** Returns an array containing only the positive integers from the given list */
    public static int[] filterPositive(List<Integer> L) {
        int[] result = new int[L.size()];
        int resultIdx = 0;
        for (int i = 0; i < L.size(); i++) {
            int n = L.get(i);
            if (n > 0) {
                result[resultIdx] = n;
                resultIdx++;
            }
        }
        return result;
    }
}
