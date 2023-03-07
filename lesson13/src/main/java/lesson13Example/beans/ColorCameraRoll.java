package lesson13Example.beans;

import org.springframework.stereotype.Component;

@Component("colorCameraRoll")
public class ColorCameraRoll implements CameraRoll {
    @Override
    public void makeAShot() {
        System.out.println("-1 цветной кадр");
    }
}
