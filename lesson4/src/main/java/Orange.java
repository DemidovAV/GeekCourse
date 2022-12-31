import java.util.ArrayList;

public class Orange extends Fruit {
    private final float weight = 1.5f;

    public float getWeight() {
        return weight;
    }

    public Orange() {
    }
    public ArrayList<Orange> oranges(int a) {
        ArrayList<Orange> oranges = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            oranges.add(new Orange());
        }
        return oranges;
    }
}
