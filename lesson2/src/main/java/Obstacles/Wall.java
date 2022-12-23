package Obstacles;

public class Wall extends Obstacle {
    private double wallHeight;

    public Wall(double wallHeight) {
        if (wallHeight >= 0) {
            this.wallHeight = wallHeight;
        } else {
            throw new IllegalArgumentException("Высота стены не может быть меньше 0");
        }
    }

    public double getWallHeight() {
        return wallHeight;
    }
}
