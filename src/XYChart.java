import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;

public class XYChart extends JFrame{
    public XYChart(String applicationTitle, String chartTitle, String fileName){
        super(applicationTitle);

        ExpenseHandler expenseHandler = new ExpenseHandler();
        XYSeriesCollection dataset = expenseHandler.createDatasetXYChart(fileName);

        JFreeChart chart = createChart(dataset, chartTitle);
        ChartPanel chartPanel= new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private JFreeChart createChart(XYSeriesCollection dataset, String title){
        JFreeChart chart = ChartFactory.createXYLineChart(
                title, // Title
                "", // x-axis Label
                "", // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );

        return chart;
    }
}
