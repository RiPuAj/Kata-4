package es.ulpgc.software.View;

import es.ulpgc.software.Model.Histogram;

import javax.swing.*;

public class MainFrame extends JFrame {
    JFreeChartHistogramDisplay display;

    public MainFrame() {
        this.setTitle("Titles Types Histogram");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1040, 810);
        this.setLocationRelativeTo(null);
        this.display = new JFreeChartHistogramDisplay();
        add(display);
    }

    public void display(Histogram histogram) {
        display.display(histogram);
    }
}
