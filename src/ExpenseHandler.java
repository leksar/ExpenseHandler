import org.jfree.data.time.*;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
                    strings.add(s.replaceAll("\"", ""));
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
                    value = value + Double.parseDouble(parts[6].replaceAll(",", "."));
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
            HashMap<Date, Double> mapData = new HashMap<Date, Double>();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar firstDate = Calendar.getInstance();
            for (String s : strings) {
                String[] parts = s.split(";");
                firstDate.setTime(format.parse(parts[2]));
                if (parts[0].equals(itemCost)) {
                    double prevValue = 0d;
                    try {
                        prevValue = mapData.get(format.parse(parts[2]));
                    } catch (Exception e) {
                    }

                    mapData.put(format.parse(parts[2]),prevValue + Double.parseDouble(parts[6].replaceAll(",", ".")));

                }

            }
            TreeMap<Date, Double> sortedMap = new TreeMap<Date, Double>(new Comparator<Date>() {
                @Override
                public int compare(Date o1, Date o2) {
                    return o1.compareTo(o2);
                }
            });

            sortedMap.putAll(mapData);
            double sum = 0;
            double daysFromStart;

            for (HashMap.Entry<Date, Double> elem : sortedMap.entrySet()) {
                daysFromStart =(elem.getKey().getTime() - firstDate.getTimeInMillis())/ (24 * 60 * 60 * 1000);
                if (daysFromStart < 1d) daysFromStart = 1d;
                sum = sum + elem.getValue();
                dataset.add(new Day(elem.getKey().getDate(), 1+ elem.getKey().getMonth(), 1900 + elem.getKey().getYear()), 30*sum/daysFromStart);
                System.out.println("Sum = " + sum);
                System.out.println("daysFromStart = " + daysFromStart);
            }

        } catch (Exception e) {
            System.out.println(e + " in createTimeSeriesDataset");
        }

        TimeSeriesCollection result = new TimeSeriesCollection();
        result.addSeries(dataset);
        return result;
    }


}