package func_interface_streams._7_2_10;


import java.util.Arrays;
import java.util.stream.IntStream;

/*
Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:

1.Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
2.Первый элемент последовательности устанавливается равным этому числу.
3.Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(Rn2),
где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа. Например, mid(123456)=345.

Алгоритм, конечно, дурацкий и не выдерживающий никакой критики, но для практики работы со стримами сойдет :)
Пример ввода: 13
Пример вывода: 13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)

Требования:
1. Должен быть метод public static IntStream pseudoRandomStream(int seed)
2. Метод должен возвращать поток, удовлетворяющий условию

 */
public class Main {

    public static void main(String[] args) {
        //pseudoRandomStream(13).forEach((System.out::println));
        int seed = 13;
        System.out.println(Arrays.toString(pseudoRandomStream(seed).toArray()));
    }

    public static IntStream pseudoRandomStream(int seed) {
        //твой код здесь
        return IntStream.iterate(seed, i -> (i * i) / 10 % 1000).limit(15);
    }
}
