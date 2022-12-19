package generic_collections._6_2_14;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
Магазину нужно сохранять информацию о продажах для каждого сотрудника.
Напишите метод Map getSalesMap(Reader reader) который принимает Reader содержащий строки вида:
Алексей 3000
Дмитрий 9000
Антон 3000
Алексей 7000
Антон 8000

Метод должен получить все строки из Readera и заполнить и вернуть карту где ключом будет имя сотрудника, а значением сумма всех его продаж.
Пример ввода:

Алексей 3000
Дмитрий 9000
Антон 3000
Алексей 7000
Антон 8000
Пример вывода:
{Алексей=[10000], Дмитрий=[9000], Антон=[11000]}

Требования:
1. Должен быть метод public static Map<String, Long> getSalesMap(Reader reader)
2. Работа метода getSalesMap должна удовлетворять условию
 */
public class Main {
    public static void main(String[] args) {

    }

    public static Map<String, Long> getSalesMap(Reader reader) {
        //Твой код здесь
        Map<String, Long> result = new HashMap<>();
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNext()) {
            String name = scanner.next();
            int sale = scanner.nextInt();
            if (result.containsKey(name)) {
                result.put(name, result.get(name) + sale);
            } else {
                result.put(name, (long) sale);
            }
        }
        return result;
    }
}
