import javax.swing.*;
import java.io.*;

/**
 * Created by leksar on 22.01.2015.
 */
public class Main {
    public static void main(String[] args) {
//        PieChart demo = new PieChart("Comparison", "Which operating system are you using?");
//        demo.pack();
//        demo.setVisible(true);

//        XYChart demo2 = new XYChart("График", "Тестовый график");
//        demo2.pack();
//        demo2.setVisible(true);

        ExpenseHandler expenseHandler = new ExpenseHandler();
        try {
            String s = expenseHandler.read("expense.txt");
            System.out.println(s);
        }
        catch (Exception e){

        }


    }
}
