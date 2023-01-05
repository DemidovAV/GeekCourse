import java.util.*;

public class lesson5Main {
    public static void main(String[] args) {
        String[] wordArr = {"man", "goat", "man", "pig", "man", "pig", "fish", "goat", "fish", "man", "cat", "dog",
        "cat", "dog", "man", "goat", "cat", "fish", "pig"};
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordArr));
        System.out.println(wordSet.toString());
        for (String o : wordSet) {
            int counter = 0;
            for (String s : wordArr) {
                if (o.equals(s)) {
                    counter++;
                }
            }
            System.out.println("There are " + counter + " words \"" + o + "\" in wordArr");
        }

    }
}
