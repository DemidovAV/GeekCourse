import java.util.ArrayList;
import java.util.Arrays;

public class JavaMain {
    public static void main(String[] args) {
        Integer[] strings = {1, 2, 3, 4, 5};
        arrayElementsSwap(strings, 1, 4);
        System.out.println(Arrays.toString(strings));
        System.out.println(arrayToArrayList(strings).toString());

        Box<Apple> appleBox = new Box<>(apples(5));
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
    public static ArrayList<Object> arrayToArrayList(Object[] array) {
        ArrayList<Object> result = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            result.add(array[i]);
        }
        return result;
    }
}
