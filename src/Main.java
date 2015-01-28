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

        File file = new File("superTextFile.txt");

        try {
            if (!file.exists()) file.createNewFile();

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print("HAHAHAHA");
            } finally {
                out.close();
            }

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

        System.out.println("done");
    }
}
