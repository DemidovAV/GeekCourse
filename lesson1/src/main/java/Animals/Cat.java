package Animals;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance >= 0 && distance <= 200 ) {
            System.out.println(name + " has run " + distance + " meters.");
        } else if (distance < 0) {
            System.out.println("ATTENTION! Distance can't be negative!");
        } else {
            System.out.println("Cats can't run further than 200 meters");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cats can't swim!");
    }
}
