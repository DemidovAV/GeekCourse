import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitsInBox;

    public Box() {
        this.fruitsInBox = new ArrayList<T>();
    }

    public ArrayList<T> getFruitsInBox() {
        return fruitsInBox;
    }

    public Box(ArrayList<T> fruitsInBox) {
        this.fruitsInBox = fruitsInBox;
    }

    public Box(T... fruits) {
        this.fruitsInBox = new ArrayList<>(Arrays.asList(fruits));
    }

    public double getWeight() {
        if (fruitsInBox.size() > 0) {
            return (fruitsInBox.size() * (fruitsInBox.get(0).getWeight()));
        } else {
            return 0;
        }
    }

    public boolean compare(Box<?> incomingBox) {
        return this.getWeight() == incomingBox.getWeight();
    }

    public void throwFruits(Box<T> destBox) {
        destBox.fruitsInBox.addAll(this.fruitsInBox);
        this.fruitsInBox.clear();
    }
    public void addFruit(T fruit, int numberOfFruits) {
        for (int i = 0; i < numberOfFruits; i++) {
            fruitsInBox.add(fruit);
        }
    }

}
