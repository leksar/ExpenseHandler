import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.time.MovingAverage;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.Rotation;

import javax.swing.*;
import java.util.Random;

/**
 * Created by leksar on 23.01.2015.
 */
public class XYChart extends JFrame{
    public XYChart(String applicationTitle, String chartTitle, String fileName){
        super(applicationTitle);
        XYSeriesCollection dataset = createDataset(fileName);

        JFreeChart chart = createChart(dataset, chartTitle);
        ChartPanel chartPanel= new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private XYSeriesCollection createDataset(String fileName) {
        XYSeries dataset = new XYSeries("XY Chart");
        XYSeries dataset2 = new XYSeries("Chart 2");
        XYSeries dataset3 = new XYSeries("Chart 3");
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {
            dataset.add(rand.nextDouble()*100,rand.nextDouble()*33+66);
            dataset2.add(rand.nextDouble()*100,rand.nextDouble()*33+33);
            dataset3.add(rand.nextDouble()*100,rand.nextDouble()*33);
        }



        XYSeriesCollection result = new XYSeriesCollection();
        result.addSeries(dataset);
        result.addSeries(dataset2);
        result.addSeries(dataset3);
        return result;
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

        //TODO: what is it ?
//        PiePlot3D plot = (PiePlot3D) chart.getPlot();
//        plot.setStartAngle(45);
//        plot.setDirection(Rotation.CLOCKWISE);
//        plot.setForegroundAlpha(0.5f);
        return chart;
    }
}
