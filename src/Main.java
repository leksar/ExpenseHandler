import org.jfree.data.time.Day;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

//        PieChart demo = new PieChart("Comparison", "Which operating system are you using?");
//        demo.pack();
//        demo.setVisible(true);
//
//        XYChart demo2 = new XYChart("График", "Тестовый график", "expense.txt", "Алкоголь");
//        demo2.pack();
//        demo2.setVisible(true);

        TimeSeriesChart demo3 = new TimeSeriesChart("График по времени","Тест","expense.txt", "Продукты");
        demo3.pack();
        demo3.setVisible(true);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-28);
        System.out.println("--- MAIN ---");
        System.out.println(date);
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTime().getDate());
        System.out.println(calendar.getTime().getMonth());
        System.out.println(calendar.getTime().getYear());
        System.out.println((new Day(18,3,2001).compareTo(new Day(19,3,2002))));
        calendar.setTimeInMillis(123123l);
        System.out.println(calendar.getTime());
    }
}
