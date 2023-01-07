import java.util.Arrays;

public class Lesson6Main {

    static final int SIZE = 100000000;
    static final int HALF = SIZE/2;

    public static void main(String[] args) {
        countMethod1();
        countMethod2();
    }

    public static void countMethod1() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
        }
        long finish = System.currentTimeMillis();
        System.out.println("countMethod1 execute time is " + (finish - start)+ " ms.");
    }

    public static void countMethod2() {
        float[] array = new float[SIZE];
        float[] arrayHalf1 = new float[HALF];
        float[] arrayHalf2 = new float[HALF];
        Arrays.fill(array, 1);
        long start = System.currentTimeMillis();
        System.arraycopy(array, 0, arrayHalf1, 0, HALF);
        System.arraycopy(array, HALF, arrayHalf2, 0, HALF);
        Thread count1 = new Thread(() -> {
            for (int i = 0; i < arrayHalf1.length; i++) {
                arrayHalf1[i] = (float) (arrayHalf1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });
        Thread count2 = new Thread(() -> {
            for (int i = 0; i < arrayHalf2.length; i++) {
                arrayHalf2[i] = (float) (arrayHalf2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });
        count1.start();
        count2.start();
        System.arraycopy(arrayHalf1, 0, array, 0, HALF);
        System.arraycopy(arrayHalf2, 0, array, HALF, HALF);
        long finish = System.currentTimeMillis();
        System.out.println("countMethod2 execute time is " + (finish - start)+ " ms.");
    }

}
