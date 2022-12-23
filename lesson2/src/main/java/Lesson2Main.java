import Competitors.*;
import Obstacles.*;

public class Lesson2Main {
    public static void main(String[] args) {
        Competition[] competitors = {
                new Human("Василий", HumanSex.MALE),
                new Human("Светлана", HumanSex.FEMALE),
                new Robot("Жестянка"),
                new Cat("Мурзик"),
                new Human("Надежда", HumanSex.FEMALE),
                new Cat("Борис Анатольевич"),
                new Robot("WALL-E")
        };
         Obstacle[] obstacles = {
                 new Wall(2.1),
                 new Treadmill(500),
                 new Wall(2.2),
                 new Treadmill(20000),
                 new Wall(2.5),
                 new Treadmill(35000)
         };

         compete(competitors, obstacles);


    }
    public static void compete(Competition[] competition, Obstacle[] obstacles) {
        for(Competition comp: competition){
            for(Obstacle obs: obstacles) {
                if (obs instanceof Wall) {
                    comp.jump(((Wall) obs).getWallHeight());
                    if (((Wall) obs).getWallHeight() <= comp.getMaxJumpingHeight()) {
                        System.out.println(comp.getName() + " перепрыгивает препядствие высотой " + ((Wall) obs).getWallHeight() + " м!");
                    } else {
                        System.out.println("Участник " + comp.getName() + " не справляется с препядствием высотой " + ((Wall) obs).getWallHeight() + " м!");
                        break;
                    }
                } else {
                    comp.run(((Treadmill) obs).getDistance());
                    if (((Treadmill) obs).getDistance() <= comp.getMaxRunDistance()) {
                        System.out.println(comp.getName() + " пробегает дистанцию " + ((Treadmill) obs).getDistance() + " м!");
                    } else {
                        System.out.println("Участник " + comp.getName() + " не справляется с дистанцией " + ((Treadmill) obs).getDistance() + " м!");
                        break;
                    }
                }

            }
        }
    }

}
