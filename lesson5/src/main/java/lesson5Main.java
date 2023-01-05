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

        YellowPages directory = new YellowPages(new HashMap<>());
        directory.add("Demidov", "+79214241193");
        directory.add("Vasiliev", "+79313242233");
        directory.add("Demidov", "+792142315566");
        directory.add("Mishin", "89174444566");
        directory.add("Lopatina", "+79219787147");
        directory.add("Vasiliev", "911");
        System.out.println(directory.getYellowPages().toString());
        System.out.println(directory.get("Demidov"));
        System.out.println(directory.get("Lopatina"));
        System.out.println(directory.get("Vasiliev"));

    }
}
