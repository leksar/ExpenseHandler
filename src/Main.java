import javax.swing.*;
import java.io.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
//        PieChart demo = new PieChart("Comparison", "Which operating system are you using?");
//        demo.pack();
//        demo.setVisible(true);
        XYChart demo2 = new XYChart("График", "Тестовый график", "expense.txt");
        demo2.pack();
        demo2.setVisible(true);

        //TODO: Delete
//        ExpenseHandler expenseHandler = new ExpenseHandler();
//        try {
//            ArrayList<String> strings = new ArrayList<String>();
//            strings = expenseHandler.read("expense.txt");
//            for (String s : strings){
//                String[] parts = s.split(";");
//                System.out.println(parts[0] + " " + parts[2] + " " + parts[6]);
//
//            }
//        } catch(Exception e){
//            System.out.println("Error ! " + e);
//        }


    }
}
