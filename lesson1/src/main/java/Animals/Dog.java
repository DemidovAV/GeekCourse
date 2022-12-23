package Animals;

public class Dog  extends Animal{
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance >= 0 && distance <= 500 ) {
            System.out.println(name + " has run " + distance + " meters.");
        } else if (distance < 0) {
            System.out.println("ATTENTION! Distance can't be negative!");
        } else {
            System.out.println("Dogs can't run further than 500 meters");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance >= 0 && distance <= 10) {
            System.out.println(name + " has swum " + distance + " meters.");
        } else if (distance < 0) {
            System.out.println("ATTENTION! Distance can't be negative!");
        } else {
            System.out.println("Dogs can't swim further than 10 meters, it can drown!");
        }
    }

    public static int countDogs() {
        return dogCount;
    }

}
