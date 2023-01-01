import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitsInBox;
    private T fruit;

    public Box() {
        fruitsInBox = new ArrayList<T>();
    }

    public ArrayList<T> getFruitsInBox() {
        return fruitsInBox;
    }

    public Box(ArrayList<T> fruitsInBox) {
        this.fruitsInBox = fruitsInBox;
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
    public void addFruit(int numberOfFruits) {
        for (int i = 0; i < numberOfFruits; i++) {
            fruitsInBox.add(fruit);
        }
    }

}
