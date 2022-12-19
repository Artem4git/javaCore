package filesystem._5_3_11;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    /*
    Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
    Пример:
    InputStream последовательно возвращает четыре байта: 48 49 50 51.
    Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку: "0123".
     */
    public static void main(String[] args) {
        byte[] bytes = new byte[]{48, 49, 50, 51};
        Charset charset = StandardCharsets.US_ASCII;


    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        //Твой код здесь
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder builder = new StringBuilder();
        while (reader.ready()) {
            builder.append((char) reader.read());
        }
        reader.close();
        return builder.toString();
    }
}
