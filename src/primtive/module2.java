package primtive;

import java.math.BigInteger;


public class module2 {

    public static void main(String[] args) {
        System.out.println();
        double a = 1.0009;
        double b = 1.0001;
        double c = 2.0010;
/*        System.out.println(Math.abs(a + b - c));
        System.out.println(doubleExpression(a, b, c));
        System.out.println(drawisMonitorsCounter(30, 3));
        double d = 0x0bp3;
        System.out.println(d);
 */
        //System.out.println(charExpression(10));
        long l = 456555555;
        float f = l;
        char c1 = 'c';
        Character character = c1;
        String s = "sss";
        //int i = s;
        int i1 = 456;
        long l1 = i1;
        byte b1 = 127;
        //char c2 = b1;
        float f1 = 123.3f;
        //long l2 = f1;
        char c2 = 'a';
        int i2 = c2;
        //boolean b2 = i2;
        //System.out.println(isPowerOfTwo(-64));
        //System.out.println(isPalindrome("Was it a cat I saw?"));
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, -3, 0, -133, 122};
        int[] arr2 = {3, 5, 7, 9};
        int[] arr3 = {2, 4, 6, 8};
        //System.out.println(Arrays.toString(mergeArrays(arr2, arr3)));
        String[] roles = new String[]{"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич", "Демис Карибидис", "Лука"};
        String[] textLines = new String[]{"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.", "Аммос Федорович: Как ревизор?", "Артемий Филиппович: Как ревизор?", "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.", "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!", "Лука Лукич: Господи боже! еще и с секретным предписаньем!", "Лука Лукич: сэмпл текс Лука Лукич:", "Лука Лукич: Лука: Господи боже!  еще и с секретным предписаньем", "  "};
        System.out.println(printTextPerRole(roles, textLines));

        Human human = new Human();
        Human human2 = new Human((byte) 12, "Ivan", "Petrov", "Football");
        Human human3 = new Human((byte) 12, "Ivan", "Petrov");
    }

    public static class Human {
        //TODO your code here
        private byte age;
        private String name;
        private String secondName;
        private String favoriteSport;

        public Human() {
        }

        public Human(byte age, String name, String secondName, String favoriteSport) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
            this.favoriteSport = favoriteSport;
        }

        public Human(byte age, String name, String secondName) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
        }
    }

    public static class Cat {

        public void sayHello() {
            System.out.println("Мяу!");
        }
    }

    public static class Dog {

        public void sayHello() {
            System.out.println("Гав!");
        }

        public void catchCat(Cat cat) {
            sayHello();
            cat.sayHello();
        }
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        //Твой код здесь
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            builder.append(roles[i] + ":\n");
            for (int j = 0; j < textLines.length; j++) {
                int counter = j;
                if (textLines[j].startsWith(roles[i] + ": ")) {
                    builder.append(++counter).append(") ").append(textLines[j].replaceFirst(roles[i].concat(": "), "")).append("\n");
                }
                if (j == textLines.length - 1) {
                    builder.append("\n");
                }
            }
        }
        return builder.toString();
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        //твой код здесь
        int counterOne = 0;
        int counterTwo = 0;
        int[] result = new int[a1.length + a2.length];

        for (int i = 0; i < result.length; i++) {
            if (counterOne >= a1.length) {
                result[i] = a2[counterTwo];
                counterTwo++;
            } else if (counterTwo >= a2.length) {
                result[i] = a1[counterOne];
                counterOne++;
            } else if (a1[counterOne] < a2[counterTwo]) {
                result[i] = a1[counterOne];
                counterOne++;
            } else {
                result[i] = a2[counterTwo];
                counterTwo++;
            }
        }
        return result;
    }

    public static void printOddNumbers(int[] arr) {
        //Твой код здесь
        if (arr.length == 0) {
            return;
        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                builder.append(",").append(arr[i]);
            }
        }
        if (builder.isEmpty()) {
            return;
        }
        System.out.println(builder.deleteCharAt(0));
    }

    public int determineGroup(int age) {
        //Твой код здесь
        if (age >= 7 && age <= 13) {
            return 1;
        }
        if (age >= 14 && age <= 17) {
            return 2;
        }
        if (age >= 18 && age <= 65) {
            return 3;
        }
        return -1;
    }

    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
//        if (value <= 1) {
//            return BigInteger.valueOf(1);
//        } else {
//            return BigInteger.valueOf(value).multiply(factorial(value - 1));
//        }
    }

    public static void forCycle() {
        for (int i = 0; i < 100; ) {
            // тело цикла
            i++;
        }
    }

    public static void sv(int i) {
        switch (i) {

        }
    }

    public static boolean isPalindrome(String text) {
        String cleanText = text.replaceAll("[^a-zA-Z\\d]", "");
        StringBuilder stringBuilder = new StringBuilder(cleanText);
        return cleanText.equalsIgnoreCase(stringBuilder.reverse().toString());
    }

    public static boolean isPowerOfTwo(int value) {
        //Твой код здесь
        return Integer.bitCount(Math.abs(value)) == 1;
    }

    public static char charExpression(int a) {
        //Твой код здесь
        return (char) ('\\' + a);
    }

    public static int drawisMonitorsCounter(int monitors, int programmers) {
        return monitors % programmers;
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) <= 0.0001;
    }
}
