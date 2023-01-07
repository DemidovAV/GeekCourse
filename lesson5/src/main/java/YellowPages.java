import java.util.ArrayList;
import java.util.HashMap;

public class YellowPages {
    private HashMap<String, ArrayList<String>> yellowPages;

    public YellowPages(HashMap<String, ArrayList<String>> yellowPages) {
        this.yellowPages = yellowPages;
    }

    public HashMap<String, ArrayList<String>> getYellowPages() {
        return yellowPages;
    }

    public void add(String surname, String telephoneNumber) {
        if (!this.yellowPages.containsKey(surname)) {
            this.yellowPages.put(surname, new ArrayList<String>());
            this.yellowPages.get(surname).add(telephoneNumber);
        } else {
            this.yellowPages.get(surname).add(telephoneNumber);
        }
    }

    public String get(String surname) {
        return this.yellowPages.get(surname).toString();
    }



}
