package exception._4_2_8;

public class Main {
    public static void main(String[] args) {

    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        //Твой код здесь
        RobotConnection robotConnection = null;
        for (int i = 0; i < 3; i++) {
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                break;
            } catch (RobotConnectionException e) {
                if (i > 1) {
                    throw new RobotConnectionException("...");
                }
            } catch (Exception e) {
                if (i > 1) {
                    throw e;
                }
            } finally {
                try {
                    if (robotConnection != null) {
                        robotConnection.close();
                    }
                } catch (Exception e) {
                    //ignore
                }
            }
        }
    }

    public static void moveRobot2(RobotConnectionManager robotConnectionManager, int toX, int toY) {

        for (int i = 0; i < 3; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                break;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw new RobotConnectionException("...");
                }
            } catch (Exception e) {
                if (i > 1) {
                    throw e;
                }
            }
        }
    }
}
