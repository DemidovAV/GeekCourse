import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitsInBox;

    public Box(ArrayList<T> fruitsInBox) {
        this.fruitsInBox = fruitsInBox;
    }

    public double getWeight() {
        return(this.fruitsInBox.size() * (this.fruitsInBox.get(0).getWeight()));
    }

}
