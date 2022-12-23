package Obstacles;

public class Treadmill extends Obstacle{
    private int distance;

    public Treadmill(int distance) {
        if (distance >= 0) {
            this.distance = distance;
        } else {
            throw new IllegalArgumentException("Длина беговой дорожки не может быть меньше 0");
        }
    }

    public int getDistance() {
        return distance;
    }
}
