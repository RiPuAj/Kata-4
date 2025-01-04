package es.ulpgc.software.View;

import static org.jfree.chart.ChartFactory.createBarChart;
import es.ulpgc.software.Model.Histogram;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;




public class JFreeChartHistogramDisplay extends JPanel implements DisplayHistogram{
    @Override
    public void display(Histogram histogram) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(String key : histogram.getKeys()){
            System.out.println(key + " " + histogram.valueOf(key));
            dataset.addValue(histogram.valueOf(key) % 100000, "Frequency", key);
        }
        JFreeChart barChart = createBarChart("Titles types histogram", "Categories", "Frequencies", dataset);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setSize(800, 600);
        add(chartPanel);
    }
}
