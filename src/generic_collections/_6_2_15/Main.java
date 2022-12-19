package generic_collections._6_2_15;


import java.util.LinkedList;
import java.util.Scanner;

/*
Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в обратном порядке в System.out.

Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.

Все import объявлены за вас.
Пример ввода: 1 2 3 4 5 6 7 8 9 10
Пример вывода: 10 8 6 4 2

Требования:
1. Необходимо наличие метода public static void main(String[] args)
2. Программа должна читать данные из консоли
3. Программа должна выводить текст в консоль
 */
public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }

        int size = list.size();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (list.indexOf(list.peekLast()) % 2 == 0) {
                list.pollLast();
            } else {
                builder.append(list.pollLast()).append(" ");
            }
        }
        System.out.println(builder);
        scanner.close();
    }
}
