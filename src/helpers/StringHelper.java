package helpers;

public class StringHelper {

    /**
     * Magic function - Sort characters in a string
     */
    public static String sortStringCharacters(String str) {
        String result = "";
        for (int i = 97, j = 65; i <= 122; i++, j++) {
            for (int k = 0; k < str.length(); k++) {
                if ( (int) str.charAt(k) == i || (int) str.charAt(k) == j) {
                    result = result + str.charAt(k);
                }
            }
        }
        return result;
    }
}
