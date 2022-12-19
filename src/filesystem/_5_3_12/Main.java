package filesystem._5_3_12;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Scanner;

/*
Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех встреченных в тексте вещественных чисел
с точностью до шестого знака после запятой. Числом считается последовательность символов, отделенная от окружающего текста
пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.

На этот раз вам надо написать программу полностью, т.е. объявить  публичный класс с именем Main
и точку входа в программу — метод  main. И добавить все необходимые импорты

Пример ввода 1: 1 2 3
Пример вывода 1: 6.000000


Пример ввода 2: a1 b2 c3
Пример вывода 2: 0.000000


Пример ввода 3:  -1e3 18 .111 11bbb
Пример вывода 3: -981.889000
 */

public class Main {

    public static void main(String[] args) throws IOException {
        double result = 0.0;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                result += Double.parseDouble(scanner.next());
                String format = String.format("%f", result);
                System.out.println(format);
            } else {
                scanner.next();
            }
        }
        scanner.close();
        String format = String.format("%f", result);
        Writer writer = new PrintWriter(System.out);
        writer.write(format);
        writer.flush();
        writer.close();
    }
}
