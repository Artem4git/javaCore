package filesystem._5_2_7;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {

    }

    public int sumOfStream(InputStream inputStream) throws IOException {
        //твой код здесь
        int sum = 0;
        byte[] allBytes = inputStream.readAllBytes();
        for (int i = 0; i < allBytes.length; i++) {
            sum += allBytes[i];
        }
        return sum;
    }
}
