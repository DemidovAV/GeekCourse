package Competitors;

public interface Competition {
    void jump(double height);
    double getMaxJumpingHeight();

    void run (int length);

    int getMaxRunDistance();

    String getName();
}
