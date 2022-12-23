import Animals.Animal;
import Animals.Dog;
import Animals.HomeCat;
import Animals.Tiger;


public class MainApp {
    public static void main(String[] args) {
        Animal[] differentAnimals = {
                new HomeCat("Barsik"),
                new HomeCat("Murzik"),
                new HomeCat("Tomas"),
                new Tiger("Sherkhan"),
                new Tiger("Boris"),
                new Dog("Matthew"),
                new Dog("Bobik"),
                new Dog("Hatiko")
        };

        for (Animal o: differentAnimals) {
            o.run((int) ((Math.random() * (600 - 10 + 1)) + 10));
            o.swim((int) ((Math.random() * (15 - 2 + 1)) + 2));
        }

        createdAnimals();

    }

    public static void createdAnimals() {
        System.out.println("Overall animals created: " + Animal.countAnimals());
        System.out.println("We have " + HomeCat.countHomeCats() + " home cats");
        System.out.println("We have " + Tiger.countTigers() + " tigers");
        System.out.println("We have " + Dog.countDogs() + " dogs");
    }
}
