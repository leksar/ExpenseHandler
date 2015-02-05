import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

/**
 * Created by leksar on 05.02.2015.
 */
public class TimeSeriesChart extends JFrame{

    public TimeSeriesChart(String applicationTitle, String chartTitle, String fileName){
        super(applicationTitle);

        ExpenseHandler expenseHandler = new ExpenseHandler();
        XYSeriesCollection dataset = expenseHandler.createXYSeriesDataset(fileName);

        TimeSeriesCollection dataset2 = new TimeSeriesCollection();

        JFreeChart chart = createChart(dataset, chartTitle);
        ChartPanel chartPanel= new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private JFreeChart createChart(XYSeriesCollection dataset, String title){
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                title,
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        return chart;
    }

}
