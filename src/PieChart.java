import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by leksar on 22.01.2015.
 */
public class PieChart extends JFrame{
//    private static final long serialVersionUID = 1L;

    public PieChart(String applicationTitle, String chartTitle){
        super(applicationTitle);
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width/2, screenSize.height/2);
    }

    private PieDataset createDataset(){
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Linux",20);
        result.setValue("Mac", 20);
        result.setValue("Windows", 51);
        result.setValue("Nothings", 17);
        return result;
    }

    private JFreeChart createChart(PieDataset dataset, String title){
        JFreeChart chart = ChartFactory.createPieChart3D(title,
                dataset,
                true,
                true,
                false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(45);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
    }
}
