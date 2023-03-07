package lesson13Example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("oldCamera")
@Scope("prototype")
public class OldCamera implements Camera{
    private CameraRoll cameraRoll;

    @Value("false")
    private boolean broken;

    @Autowired
    @Qualifier("blackAndWhiteCameraRoll")
    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    @Override
    public void doPhotograph() {
        if (isBroken()) {
            System.out.println("Фотоаппарат сломан!");
            return;
        }
        System.out.println("Щёлк!");
        cameraRoll.makeAShot();
    }

    public boolean isBroken() {
        return broken;
    }
    public void breaking() {
        this.broken = true;
    }

    @PostConstruct
    public void ready() {
        System.out.println("Фотоаппарат готов к использованию!");
    }

}
