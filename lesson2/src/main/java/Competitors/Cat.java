package Competitors;

public class Cat implements Competition{
    private final String name;

    private final String type = "Робот";
    private final double catMaxJumpHeight = 2.5;
    private final int catMaxRunDistance = 18000;

    public Cat(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void jump(double height) {
        System.out.println(type + " " + name + " делает попытку перепрыгнуть стену высотой " + height + " м.");
    }
    public void run(int distance) {
        System.out.println(type + " " + name + " делает попытку пробежать дистанцию " + distance + " м.");
    }

    @Override
    public int getMaxRunDistance() {
        return catMaxRunDistance;
    }

    @Override
    public double getMaxJumpingHeight() {
        return catMaxJumpHeight;
    }
}
