import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.*;
import java.util.ArrayList;

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

    public XYSeriesCollection createDatasetXYChart(String fileName){
        XYSeries dataset = new XYSeries("XY Chart");
        try {
            ArrayList<String> strings = this.read(fileName);

            double i = 1D;
            double value = 0;
            for (String s : strings) {

                String[] parts = s.split(";");
                if (parts[0].equals("\"Продукты\"")) {
                    value = value + Double.parseDouble(parts[6].replaceAll("\"", "").replaceAll(",", "."));
                    dataset.add(i, value/i);
                    System.out.println("added element " + i + " = " + parts[6] + " value = " + value);
                    i = i + 1D;
                }

            }
            XYSeriesCollection result = new XYSeriesCollection();
            result.addSeries(dataset);
            return result;
        }
        catch (FileNotFoundException e) {
            System.out.println(e + " in createDataset");
        }
        return null;
    }


}