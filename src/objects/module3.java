package objects;

public class module3 {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.DOWN);
        moveRobot(robot, 10, -10);
        System.out.println(robot.getX() + " -- " + robot.getY());
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        private int x;
        private int y;
        private Direction dir;

        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Direction.UP) {
                y++;
            }
            if (dir == Direction.DOWN) {
                y--;
            }
            if (dir == Direction.LEFT) {
                x--;
            }
            if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        // your code
        while (!robot.getDirection().equals(Direction.UP)) {
            robot.turnRight();
            System.out.println(robot.getDirection());
        }

        if (robot.getX() < toX) {
            robot.turnRight();
        } else {
            robot.turnLeft();
        }
        while (robot.getX() != toX) {
            robot.stepForward();
            System.out.println(robot.getX() + " _ " + robot.getY());
        }

        while (!robot.getDirection().equals(Direction.RIGHT)) {
            robot.turnRight();
        }

        if (robot.getY() < toY) {
            robot.turnLeft();
        } else {
            robot.turnRight();
        }

        while (robot.getY() != toY) {
            robot.stepForward();
            System.out.println(robot.getX() + " _ " + robot.getY());
        }
    }
}