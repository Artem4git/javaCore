package filesystem._5_3_9;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = Files.newBufferedReader(Paths.get("file.txt"), StandardCharsets.UTF_8);

        byte[] b = "Ы".getBytes();

        for (int i = 0; i < b.length; i++) {
            System.out.print(((int) b[i] ^ -1 << 8) + " ");
        }

        int x = System.in.read();
        System.out.println(x);
    }
}
