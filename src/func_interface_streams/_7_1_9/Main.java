package func_interface_streams._7_1_9;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/*
Дан предикат condition и две функции ifTrue и ifFalse.
Напишите метод ternaryOperator, который из них построит новую функцию,
возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.

Пример использования метода (можно было все свернуть в одну строчку, но для наглядности все элементы вынесены в отдельные переменные):

Predicate<Object> condition = Objects::isNull;
Function<Object, Integer> ifTrue = obj -> 0;
Function<CharSequence, Integer> ifFalse = CharSequence::length;
Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

Результирующая функция будет для нулевых ссылок на String возвращать 0, а для ненулевых ссылок возвращать длину строки.

Все импорты объявлены за вас.
Требования:
1. Должен быть метод public static <T, U> Function<T, U>
ternaryOperator(Predicate<? super T> condition, Function<? super T, ? extends U> ifTrue, Function<? super T, ? extends U> ifFalse)
2. Метод должен возвращать функцию
3. Используйте лямбда-выражение

 */
public class Main {

    public static void main(String[] args) {

        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        safeStringLength.apply(null);//0
        safeStringLength.apply("Hi");//2

    }

    public static <T, U> Function<T, U> ternaryOperator(Predicate<? super T> condition, Function<? super T, ? extends U> ifTrue, Function<? super T, ? extends U> ifFalse) {
        //Твой код здесь

        return t -> condition.test(t) ? (ifTrue.apply(t)) : (ifFalse.apply(t));

    }
}
