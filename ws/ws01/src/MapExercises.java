import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercises {
    /** Returns a map from each integer x in the list to a list (without duplicates)
     * of all integers in the list that are less than x. */
    public static Map<Integer, List<Integer>> buildLessThanMap(List<Integer> L) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < L.size(); i++) {
            if (!result.containsKey(L.get(i))) {
                result.put(L.get(i), new ArrayList<>());
            }
            for (int j = 0; j < L.size(); j++) {
                if (L.get(j) < L.get(i)) {
                    if (!result.get(L.get(i)).contains(L.get(j))) {
                        result.get(L.get(i)).add(L.get(j));
                    }
                }
            }
        }
        return result;
    }

    void main() {
        List<Integer> l = new ArrayList<>(List.of(4, 1, 3, 3));
        IO.println(buildLessThanMap(l));
    }
}
