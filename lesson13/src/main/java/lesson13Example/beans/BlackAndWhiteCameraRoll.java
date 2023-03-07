package lesson13Example.beans;

import org.springframework.stereotype.Component;

@Component("blackAndWhiteCameraRoll")
@UnproducableCameraRoll(usingCameraRollClass = ColorCameraRoll.class)
public class BlackAndWhiteCameraRoll implements CameraRoll{
    @Override
    public void makeAShot() {
        System.out.println("-1 черно белый кадр");
    }
}
