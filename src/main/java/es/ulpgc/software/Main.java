package es.ulpgc.software;

import es.ulpgc.software.Controller.TsvTitleReader;
import es.ulpgc.software.Controller.TitleTypeHistogram;
import es.ulpgc.software.Model.Histogram;
import es.ulpgc.software.View.MainFrame;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TsvTitleReader reader = new TsvTitleReader(new File("C:\\Users\\javi_\\OneDrive\\Escritorio\\24-25\\IS2\\Finales\\kata2JPR\\title.basics.tsv"));
        Histogram histogram = new TitleTypeHistogram(reader.read());
        MainFrame mainFrame = new MainFrame();
        mainFrame.display(histogram);
        mainFrame.setVisible(true);
    }
}


