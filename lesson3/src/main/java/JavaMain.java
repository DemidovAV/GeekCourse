import java.io.IOException;

public class JavaMain {
    public static void countArray(String[][] array) {
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++ ) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(array, i, j);
                }

            }
        }
        System.out.println("The sum of given array is " + sum);

    }

    public static void main(String[] args) {
        String[][] myArray = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "2ss"}
        };

        try {
            countArray(myArray);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }
}
