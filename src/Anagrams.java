import helpers.StringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

    public static void main(String[] args) {
        String[] strings = {"star", "rats", "car", "arc", "arts", "stars", "star"};
        groupByAnagrams(strings);
    }

    /**
     * Given a list of strings, figure out which of the strings are anagrams and return the grouped strings by matching
     * anagrams
     *
     * Input: ["star", "rats", "car", "arc", "arts", "stars"]
     * Output: [ ["star", "rats", "arts"], ["car", "arc"], ["stars"] ]
     */
    public static void groupByAnagrams(String[] input) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : input) {

            // Assumption: No strange non-alpha characters
            // Assumption: Duplicates are okay to show up again

            // Assumption: anagrams are case-insensitive
            str = str.toLowerCase();

            String key = StringHelper.sortStringCharacters(str);
            if (!anagrams.containsKey(key)) {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                anagrams.put(key, strings);
            }
            else {
                List<String> strings = anagrams.get(key);
                strings.add(str);
                anagrams.put(key, strings);
            }
        }

        // Assumption: order doesn't matter in output
        System.out.println(anagrams.values());
    }

}
