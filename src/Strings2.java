public class Strings2 {

    public static void main (String[] args) {

    }

    /**
     * Given a string, return a string where for every char in the original, there are two chars.
     *
     * doubleChar("The") → "TThhee"
     * doubleChar("AAbb") → "AAAAbbbb"
     * doubleChar("Hi-There") → "HHii--TThheerree"
     */
    public static String doubleChar(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            result.append(str.charAt(i)).append(str.charAt(i));
        }
        return result.toString();
    }

    /**
     * Return true if the string "cat" and "dog" appear the same number of times in the given string.
     *
     * catDog("catdog") → true
     * catDog("catcat") → false
     * catDog("1cat1cadodog") → true
     */
    public static boolean catDog(String str) {
        int cats = countSubString(str, "cat");
        int dogs = countSubString(str, "dog");
        return cats == dogs;
    }
    private static int countSubString(final String input, final String sub) {
        int count = 0;
        int idx = 0;
        while (input.indexOf(sub, idx) != -1) {
            count++;
            idx = input.indexOf(sub, idx) + 1;
        }
        return count;
    }

}
