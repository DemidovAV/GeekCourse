package lesson13Example;

import org.springframework.stereotype.Component;

public class CameraImpl implements Camera {
    private CameraRoll cameraRoll;

    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    @Override
    public void doPhotograph() {
        System.out.println("Щелк!");
        cameraRoll.makeAShot();
    }
}
