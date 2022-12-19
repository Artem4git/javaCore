package exception._4_2_8;

public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    @Override
    void close();
}
