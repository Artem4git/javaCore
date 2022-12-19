package func_interface_streams._7_2_11;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/*
Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.

Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:

minMaxConsumer.accept(min, max);

Если стрим не содержит элементов, то вызовите:

minMaxConsumer.accept(null, null);

Требования:
1. Должен быть метод public <T> void findMinMax(
                            Stream<? extends T> stream,
                            Comparator<? super T> order,
                            BiConsumer<? super T, ? super T> minMaxConsumer)
2. Метод должен находить минимум и максимум в потоке, с помощью order.
3. Полученные данные должны быть записаны minMaxConsumer, согласно условию

 */
public class Main {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(123, 54325, 456, 567, 768, 7689, 78, 35, 132);
        Comparator<? super Integer> comparator = Integer::compare;
        BiConsumer<? super Integer, ? super Integer> biConsumer = (x1, x2) -> System.out.println("min: " + x1 + "\nmax: " + x2);
        findMinMax(stream, comparator, biConsumer);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        //Твой код здесь
        List<? extends T> list = stream.sorted(order).toList();
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }
}
