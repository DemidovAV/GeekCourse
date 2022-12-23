package Competitors;

public class Robot implements Competition{
    private final String name;

    private final String type = "Робот";
    private final double robotMaxJumpHeight = 5.5;
    private final int robotMaxRunDistance = 20000;

    public Robot(String name) {
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
        return robotMaxRunDistance;
    }

    @Override
    public double getMaxJumpingHeight() {
            return robotMaxJumpHeight;
    }

}
