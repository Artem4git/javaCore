package filesystem._5_2_8;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) {

    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        //твой код здесь
        byte[] allBytes = inputStream.readAllBytes();
        for (byte allByte : allBytes) {
            if ((allByte % 2) == 0) {
                outputStream.write(allByte);
                outputStream.flush();
                outputStream.close();
            }
        }
    }
}
