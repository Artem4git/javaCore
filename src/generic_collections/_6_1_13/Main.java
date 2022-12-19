package generic_collections._6_1_13;

/*
Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение.
Создайте класс DynamicArray, который хранит в себе массив, и имеет методы для добавления
void add(T el), void remove(int index) удаления и извлечения T get(int index) из него элементов,
при переполнении текущего массива, должен создаваться новый, большего размера.

Для возможности работы с различными классами DynamicArray должен быть дженериком.
Для решения задачи можно воспользоваться методами из класса java.util.Arrays.
Импорт этого класса уже объявлен в тестирующей системе. Добавлять его явно не нужно
Требования:
1. должен быть класс public static class DynamicArray
2. класс DynamicArray должен иметь методы публичные void add(T el), void remove(int index) и T get(int index)
3. В случае подбора некорректного индекса ожидается, что метод get выбросит ArrayIndexOutOfBoundsException
4. класс DynamicArray должен  иметь публичный конструктор по умолчанию
5. работа методов должна соответствовать условию

 */
public class Main {
    public static void main(String[] args) {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.add("1");
        dynamicArray.add("2");
        dynamicArray.add("3");
        System.out.println(dynamicArray.get(0));
        System.out.println(dynamicArray.get(1));
        System.out.println(dynamicArray.get(2));
        System.out.println(dynamicArray.get(3));

    }

    public static class DynamicArray<T> {
        //Реализуй класс здесь
        private Object[] array;

        private int size = 0;

        public DynamicArray() {
            this.array = new Object[10];
        }

        public void add(T el) {
            if (size == array.length - 1) {
                resize(array.length * 2);
            }
            array[size++] = el;
            System.out.println("size = " + size);
        }

        public void remove(int index) {
            if (index < 0 || index > size - 1) {
                throw new ArrayIndexOutOfBoundsException("..");
            }
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            array[size] = null;
            size--;
        }

        public T get(int index) {
            if (index < 0 || index > size - 1) {
                throw new ArrayIndexOutOfBoundsException("..");
            }
            return (T) array[index];
        }

        private void resize(int newLength) {
            Object[] newArray = new Object[newLength];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }
}
