import org.jfree.data.time.*;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class ExpenseHandler {

    public static ArrayList<String> read(String fileName) throws FileNotFoundException {
        ArrayList<String> strings = new ArrayList<String>();
        exists(fileName);
        File file = new File(fileName);
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader(file.getAbsolutePath()));
            try {
                String s;
                while ((s =inputFile.readLine()) != null) {
                    strings.add(s);
                }
            } finally {
                inputFile.close();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        return strings;
    }

    private static void exists(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    public XYSeriesCollection createXYSeriesDataset(String fileName, String costItem){
        XYSeries dataset = new XYSeries("XY Chart");
        try {
            ArrayList<String> strings = this.read(fileName);

            double i = 1D;
            double value = 0;
            for (String s : strings) {

                String[] parts = s.split(";");
                if (parts[0].equals(costItem)) {
                    value = value + Double.parseDouble(parts[6].replaceAll("\"", "").replaceAll(",", "."));
                    dataset.add(i, value/i);
 //                 System.out.println("added element " + i + " = " + parts[6] + " value = " + value);
                    i = i + 1D;
                }

            }
            XYSeriesCollection result = new XYSeriesCollection();
            result.addSeries(dataset);
            return result;
        }
        catch (FileNotFoundException e) {
            System.out.println(e + " in createXYSeriesDataset");
        }
        return null;
    }

    public TimeSeriesCollection createTimeSeriesDataset(String fileName, String itemCost){
        TimeSeries dataset = new TimeSeries("Time Chart");
        try {
            ArrayList<String> strings = this.read(fileName);
            boolean firstString = true;
            for (String s : strings) {
                if (firstString) {
                    String[] parts = s.split(";");
                    System.out.println(parts[0]);
                    if (parts[0].equals(itemCost)){
                        firstString = false;
                    }

                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e + " in createTimeSeriesDataset");
        }

//        for (int i = 1; i < 50; i++) {
//            calendar.add(Calendar.HOUR,24);
//            dataset.add(new Day(calendar.getTime().getDate(), 1 + calendar.getTime().getMonth(), 1900 + calendar.getTime().getYear()), i);
//
//        }

        TimeSeriesCollection result = new TimeSeriesCollection();
        result.addSeries(dataset);
        return result;
    }


}