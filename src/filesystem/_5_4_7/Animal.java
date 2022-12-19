package filesystem._5_4_7;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

/*
Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal.
Массив байт устроен следующим образом. Сначала идет число типа int, записанное при помощи ObjectOutputStream.writeInt(size).
Далее подряд записано указанное количество объектов типа Animal, сериализованных при помощи ObjectOutputStream.writeObject(animal).

Если вдруг массив байт не является корректным представлением массива экземпляров Animal,
то метод должен бросить исключение java.lang.IllegalArgumentException.

Причины некорректности могут быть разные. Попробуйте подать на вход методу разные некорректные данные и посмотрите,
какие исключения будут возникать. Вот их-то и нужно превратить в IllegalArgumentException и выбросить.
Если что-то забудете, то проверяющая система подскажет. Главное не глотать никаких исключений, т.е. не оставлять нигде пустой catch.
 */
class Animal implements Serializable {

    public static void main(String[] args) throws Exception {
        /*
        Path path = Paths.get("src/filesystem/_5_4_7/file");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeInt(4);
            objectOutputStream.writeObject(new Animal("name1"));
            objectOutputStream.writeObject(new Animal("name2"));
            objectOutputStream.writeObject(new Animal("name3"));
        }
        FileInputStream fileInputStream = new FileInputStream("src/filesystem/_5_4_7/file");
        byte[] bytes = fileInputStream.readAllBytes();
        System.out.println(Arrays.toString(deserializeAnimalArray(bytes)));
         */
        byte[] intermediate = null;
        try (
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(output)) {

            oos.writeInt(3);
            oos.writeObject(new Animal("Dog"));
            oos.writeObject(new Animal("Cat"));
            oos.writeObject(new Animal("Mouse"));

            output.flush();
            intermediate = output.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(intermediate));
        Animal[] animals = deserializeAnimalArray(intermediate);
        System.out.println(Arrays.toString(animals));

    }

    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public static Animal[] deserializeAnimalArray(byte[] data) throws IndexOutOfBoundsException {
        //Твой код здесь
        Animal[] animals = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int first = objectInputStream.readInt();
            animals = new Animal[first];
            for (int i = 0; i < first; i++) {
                animals[i] = (Animal) objectInputStream.readObject();
            }
        } catch (EOFException | ClassCastException | NegativeArraySizeException e) {
            throw new IllegalArgumentException(e);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return animals;
    }

    public static Animal[] deserializeAnimalArray2(byte[] data) {
        //Твой код здесь
        Animal[] animals = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int first = objectInputStream.readInt();
            animals = new Animal[first];
            for (int i = 0; i < first; i++) {
                animals[i] = (Animal) objectInputStream.readObject();
            }
        } catch (IOException | ClassCastException | NegativeArraySizeException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        return animals;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
