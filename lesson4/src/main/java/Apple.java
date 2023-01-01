import java.util.ArrayList;

public class Apple extends Fruit {
    private final float weight = 1.0f;

    public float getWeight() {
        return weight;
    }

    public Apple() {
    }
    public static ArrayList<Apple> apples(int a) {
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            apples.add(new Apple());
        }
        return apples;
    }
}
