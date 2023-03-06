package lesson13Example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("lesson13Example")
public class AppConfig {


    @Bean(name="newCamera")
    public Camera newCamera(CameraRoll colorCameraRoll){
        CameraImpl camera = new CameraImpl();
        camera.setCameraRoll(colorCameraRoll);
        return camera;
    }
    @Bean(name="oldCamera")
    public Camera oldCamera(CameraRoll blackAndWhiteCameraRoll){
        CameraImpl camera = new CameraImpl();
        camera.setCameraRoll(blackAndWhiteCameraRoll);
        return camera;
    }
}
