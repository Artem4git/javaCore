package primtive;

import objects.module3;

public class Main {

    public static void main(String[] args) {

        module3.Robot robo = new module3.Robot(13, 12, module3.Direction.DOWN);

        System.out.println("Direction before" + robo.getDirection());
        System.out.println("x before" + robo.getX());
        System.out.println("y before" + robo.getY());

        module3.moveRobot(robo, 65, 33);

        System.out.println("Direction after" + robo.getDirection());
        System.out.println("x after" + robo.getX());
        System.out.println("y after" + robo.getY());

    }
}
