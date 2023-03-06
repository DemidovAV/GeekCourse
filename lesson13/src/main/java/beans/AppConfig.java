package beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("beans")
public class AppConfig {


    @Bean(name = "blackAndWhiteCamera")
    public Camera blackAndWhiteCamera(CameraRoll blackAndWhiteCameraRoll) {
        Camera camera = new Camera();
        camera.setCameraRoll(blackAndWhiteCameraRoll);
        return camera;
    }

    @Bean(name = "blackAndWhiteCamera")
    public Camera colorCamera(CameraRoll colorCameraRoll) {
        Camera camera = new Camera();
        camera.setCameraRoll(colorCameraRoll);
        return camera;
    }
}
