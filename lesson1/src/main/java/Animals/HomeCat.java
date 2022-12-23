package Animals;

public class HomeCat extends Cat {
    private static int homeCatCount = 0;

    public HomeCat(String name) {
        super(name);
        homeCatCount++;
    }

    public static int countHomeCats() {
        return homeCatCount;
    }
}
