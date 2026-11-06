import java.util.Comparator;
import java.util.List;

public class WordComparators {
    private static class XComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int s1x = 0;
            int s2x = 0;

            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == 'x') {
                    s1x++;
                }
            }
            for (int i = 0; i < s2.length(); i++) {
                if (s2.charAt(i) == 'x') {
                    s2x++;
                }
            }

            return s1x - s2x;
        }
    }

    private static class CharComparator implements Comparator<String> {
        private char c;

        CharComparator(char c) {
            this.c = c;
        }

        @Override
        public int compare(String s1, String s2) {
            int s1c = 0;
            int s2c = 0;

            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == c) {
                    s1c++;
                }
            }
            for (int i = 0; i < s2.length(); i++) {
                if (s2.charAt(i) == c) {
                    s2c++;
                }
            }

            return s1c - s2c;
        }
    }

    private static class CharListComparator implements Comparator<String> {
        private List<Character> chars;

        CharListComparator(List<Character> chars) {
            this.chars = chars;
        }

        @Override
        public int compare(String s1, String s2) {
            int s1c = 0;
            int s2c = 0;

            for (int i = 0; i < s1.length(); i++) {
                if (chars.contains(s1.charAt(i))) {
                    s1c++;
                }
            }
            for (int i = 0; i < s2.length(); i++) {
                if (chars.contains(s2.charAt(i))) {
                    s2c++;
                }
            }

            return s1c - s2c;
        }
    }

    /** Returns a comparator that orders strings by the number of lowercase 'x' characters (ascending). */
    public static Comparator<String> getXComparator() {
        return new XComparator();
    }

    /** Returns a comparator that orders strings by the count of the given character (ascending). */
    public static Comparator<String> getCharComparator(char c) {
        return new CharComparator(c);
    }

    /** Returns a comparator that orders strings by the total count of the given characters (ascending). */
    public static Comparator<String> getCharListComparator(List<Character> chars) {
        return new CharListComparator(chars);
    }
}
