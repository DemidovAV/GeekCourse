package Animals;

public class Tiger extends Cat {
    private static int tigerCount = 0;

    public Tiger(String name) {
        super(name);
        tigerCount++;
    }

    public static int countTigers() {
        return tigerCount;
    }
}
