package objects._3_5_7;

public class Main {

    public static void main(String[] args) {
        String[] spam = {"плохой", "отстой"};
        SpamAnalyzer spamA = new SpamAnalyzer(spam);
        NegativeTextAnalyzer negativeTA = new NegativeTextAnalyzer();
        TooLongTextAnalyzer tooLongTA = new TooLongTextAnalyzer(25);
        TextAnalyzer[] analyzers = {spamA, negativeTA, tooLongTA};
        System.out.println(checkLabels(analyzers, "Хороший текст для теста."));
        System.out.println(checkLabels(analyzers, "Плохой текст для теста, так как это :( ужас."));
        System.out.println(checkLabels(analyzers, "Плохой текст для теста, полный отстой."));
        System.out.println(checkLabels(analyzers, "И это все, что вы хотели написать в комментариях.Да ну, вообще..."));
    }

    //static убрать
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        //Твой код здесь
        for (TextAnalyzer analyzer : analyzers) {
            if (analyzer.processText(text).equals(Label.OK)) {
                continue;
            }
            return analyzer.processText(text);
        }
        return Label.OK;
    }
}

//    Для большегопонимания при создании checkLabels:TextAnalyzer[]analyzers-это
//    массив из созданных{new SpamAnalyzer,new NegativeTextAnalyzer,new TooLongTextAnalyzer}.
//    Честно до меня долго не могло дойти,пока не подсмотрел в интернете.
//    Затем решение пришло само собой в виде цикла для всех и сравнения.processText()c Label.OK.

/*
Ребят, задача мне далась крайне сложно, потрачено в районе 15 часов. Если комент не удалят, надеюсь он вам поможет, вот к чему я пришел:
1. Решение должно быть в таком виде:
public static Label checkLabels(TextAnalyzer[] analyzers, String text) {}
abstract class KeywordAnalyzer implements TextAnalyzer {}
class SpamAnalyzer extends KeywordAnalyzer {}
class NegativeTextAnalyzer extends KeywordAnalyzer {}
class TooLongTextAnalyzer implements TextAnalyzer{}
2. Модификаторы static должны быть убраны после тестирования в IDE.
3. Входную строку нужно НЕ сравнивать с ключевыми словами, а искать ключевые слова в входной строке.
4. Метод  public Label processText(String text) должен быть реализован именно! в классе  KeywordAnalyzer (он является одинаковым для классов наследников, то есть для SpamAnalyzer и NegativeTextAnalyzer﻿)
5. Конструкторы должны быть public (везде где можно поставьте паблик, иначе не пропустит (также напоминаю, что нужно везде убрать статик)
6. Енам и интерфейс в коде писать не нужно, они там по умолчанию
 */
