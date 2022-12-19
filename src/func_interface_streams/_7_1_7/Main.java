package func_interface_streams._7_1_7;

import java.util.function.UnaryOperator;

public class Main {
    int param;

    public Main(int param) {
        this.param = param;
    }

    public static void main(String[] args) {
        Main main = new Main(2);
        System.out.println(main.sqrt());

    }

    public UnaryOperator<Integer> sqrt() {
        //Твой код здесь
        return (s) -> (s * s);
    }

}
