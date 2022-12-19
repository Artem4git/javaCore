package exception._4_3_6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

    }

    public static void logging() {
        //Твой код здесь
        Logger logger = Logger.getLogger("com.javamentor.logging.Test");
        logger.log(Level.INFO,"Все хорошо");
        logger.log(Level.WARNING,"Произошла ошибка");
    }
}