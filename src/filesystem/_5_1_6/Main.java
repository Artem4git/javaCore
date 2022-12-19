package filesystem._5_1_6;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file1 = new File(".\\a\\b\\..\\b\\c\\.\\file.txt");
        System.out.println(file1.getCanonicalPath());

        File file2 = new File("a\\b\\c\\file.txt");
        System.out.println(file2.getCanonicalPath());

        File file3 = new File("a\\b\\..\\file.txt");
        System.out.println(file3.getCanonicalPath());

        File file4 = new File("a\\..\\b\\c\\file.txt");
        System.out.println(file4.getCanonicalPath());


        File file5 = new File("a\\.\\b\\..\\c\\.\\file.txt");
        System.out.println(file5.getCanonicalPath());
    }
}
