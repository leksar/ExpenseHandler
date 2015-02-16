import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

//        PieChart demo = new PieChart("Comparison", "Which operating system are you using?");
//        demo.pack();
//        demo.setVisible(true);
//
//        XYChart demo2 = new XYChart("График", "Тестовый график", "expense.txt");
//        demo2.pack();
//        demo2.setVisible(true);

        TimeSeriesChart demo3 = new TimeSeriesChart("График по времени","Тест","exprense.txt");
        demo3.pack();
        demo3.setVisible(true);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR,24*25);
        System.out.println(date);
        System.out.println(calendar.getTime());
    }
}
