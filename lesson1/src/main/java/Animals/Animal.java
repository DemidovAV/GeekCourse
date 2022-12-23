package Animals;

public abstract class Animal {
    String name;
    static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int countAnimals() {
        return animalCount;
    }

}
