import java.util.ArrayList;
import java.util.Arrays;

public class JavaMain {
    public static void main(String[] args) {
        Integer[] strings = {1, 2, 3, 4, 5};
        arrayElementsSwap(strings, 1, 4);
        System.out.println(Arrays.toString(strings));
        System.out.println(arrayToArrayList(strings).toString());

        Box<Apple> appleBox1 = new Box<>(Apple.apples(5));
        Box<Orange> orangeBox = new Box<>(new Orange(), new Orange(), new Orange());
        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple(),5);
        System.out.println(appleBox2.getFruitsInBox().size());
        System.out.println("Сейчас в коробке appleBox2 " + appleBox2.getFruitsInBox().size() + " яблок");
        System.out.println(appleBox2.getFruitsInBox());
        System.out.println(appleBox1.getFruitsInBox());

        System.out.println("Вес коробки appleBox1: " + appleBox1.getWeight() + " кг.");
        System.out.println("Вес коробки appleBox2: " + appleBox2.getWeight() + " кг.");
        System.out.println("Вес коробки orangeBox: " + orangeBox.getWeight() + " кг.");
        System.out.println(appleBox1.compare(orangeBox));
        System.out.println(appleBox1.compare(appleBox2));
        appleBox1.throwFruits(appleBox2);
        System.out.println("Вес коробки appleBox1: " + appleBox1.getWeight() + " кг.");
        System.out.println("Вес коробки appleBox2: " + appleBox2.getWeight() + " кг.");
        System.out.println("Сейчас в коробке appleBox1 " + appleBox1.getFruitsInBox().size() + " яблок");
        System.out.println("Сейчас в коробке appleBox2 " + appleBox2.getFruitsInBox().size() + " яблок");

        appleBox2.addFruit(new Apple(), 5);
        System.out.println("Сейчас в коробке appleBox2 " + appleBox2.getFruitsInBox().size() + " яблок");


    }

    public static void arrayElementsSwap(Object[] array, int a, int b) {
        if (a < 0 || b < 0 || a >= array.length || b >= array.length) {
            throw new IllegalArgumentException("Порядковый номер элементов должен быть больше -1 и быть меньше длины массива!");
        } else {
            Object temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }
    public static <T> ArrayList<T> arrayToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
