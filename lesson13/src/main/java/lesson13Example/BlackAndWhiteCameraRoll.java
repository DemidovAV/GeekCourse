package lesson13Example;

import org.springframework.stereotype.Component;

@Component("blackAndWhiteCameraRoll")
public class BlackAndWhiteCameraRoll implements CameraRoll{
    @Override
    public void makeAShot() {
        System.out.println("-1 черно белый кадр");
    }
}
