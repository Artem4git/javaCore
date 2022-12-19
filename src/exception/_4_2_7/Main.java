package exception._4_2_7;

public class Main {
    public static void main(String[] args) {
        try (Car car = new Car()) {
            car.drive();
        } catch (RuntimeException e) {
            e.addSuppressed(e);
        }

    }

    public static class Car implements AutoCloseable {

        public void drive() {
            System.out.println("Машина поехала.");
        }

        @Override
        public void close() {
            System.out.println("Машина закрывается...");
        }
    }
}
