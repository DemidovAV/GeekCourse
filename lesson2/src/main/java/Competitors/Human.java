package Competitors;

public class Human implements Competition {

    private String name;
    private HumanSex sex;

    private final String type = "Человек";
    private final double maleMaxJumpHeight = 2.45;
    private final double femaleMaxJumpHeight = 2.09;
    private final int maleMaxRunDistance = 40000;
    private final int femaleMaxRunDistance = 35000;

    public Human(String name, HumanSex sex) {
        this.name = name;
        this.sex = sex;
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
        if (this.sex == HumanSex.MALE) {
            return maleMaxRunDistance;
        } else {
            return femaleMaxRunDistance;
        }
    }
    @Override
    public double getMaxJumpingHeight() {
        if (this.sex == HumanSex.MALE) {
            return maleMaxJumpHeight;
        } else {
            return femaleMaxJumpHeight;
        }
    }

}
