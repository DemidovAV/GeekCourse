public class MyArrayDataException extends NumberFormatException{

    public MyArrayDataException(String[][] array, int row, int column) {
        super("Invalid data in " + row + " row, " + column + " column: " + array[row][column]);
    }
}
