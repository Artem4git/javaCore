package func_interface_streams._7_2_12;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов,
и в конце выводящую 10 наиболее часто встречающихся слов.

Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр.
Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".

Подсчет слов должен выполняться без учета регистра, т.е. "МАМА",
"мама" и "Мама" — это одно и то же слово. Выводите слова в нижнем регистре.

Если в тексте меньше 10 уникальных слов, то выводите сколько есть.

Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.

Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.

Пример ввода 2:

Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus.
Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur.
Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.

Пример вывода 2:

consectetur
faucibus
ipsum
lorem
adipiscing
amet
dolor
eget
elit
mi

 */
public class Main {

    public static void main(String[] args) throws IOException {

//        Files.lines(Paths.get(args[0]))
//                .flatMap(line -> Stream.of(line.split("\\s+")))
//                .map(String::toLowerCase)
//                .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum))
//                .entrySet()
//                .stream()
//                .sorted((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue())
//                .forEach(System.out::println);

        new Scanner(System.in).useDelimiter("(?U)[^\\p{L}\\d]+").tokens()
                .collect(Collectors.toMap(String::toLowerCase, value -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
                .forEach((k, v) -> System.out.println(k));
    }
}
