package lesson13Example.beans;

public interface Camera {
    CameraRoll getCameraRoll();
    void setCameraRoll(CameraRoll cameraRoll);
    void breaking();
    boolean isBroken();
    void doPhotograph();
    void ready();
}
