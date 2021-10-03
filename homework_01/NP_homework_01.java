package homework_01;

import java.io.IOException;

public class NP_homework_01 {
    public static void main(String[] args) {

        try {
            // file_copy.func(args[0], args[1],1);
            // write_print.func("number1.txt");
            // write_print.func3("number1.txt");
            // write_print.func4("number2.txt");
            // write_print.func6("number2.txt");
            // aver_devia.func1(1000, "random.dat");
            aver_devia.func2("random.dat");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
