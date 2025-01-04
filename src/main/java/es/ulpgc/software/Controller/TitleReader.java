package es.ulpgc.software.Controller;

import es.ulpgc.software.Model.Title;

import java.io.IOException;
import java.util.List;

public interface TitleReader {
    List<Title> read() throws IOException;
}
