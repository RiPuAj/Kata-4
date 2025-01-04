package es.ulpgc.software;

import es.ulpgc.software.Controller.TsvTitleReader;
import es.ulpgc.software.Controller.TitleTypeHistogram;
import es.ulpgc.software.Model.Histogram;
import es.ulpgc.software.Model.Title;
import es.ulpgc.software.View.MainFrame;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        TsvTitleReader reader = new TsvTitleReader(new File("C:\\Users\\javi_\\OneDrive\\Escritorio\\24-25\\IS2\\Finales\\kata2JPR\\title.basics.tsv"));
    }
}


