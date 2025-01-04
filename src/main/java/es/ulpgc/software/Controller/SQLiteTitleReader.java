package es.ulpgc.software.Controller;

import es.ulpgc.software.Model.Title;

import java.io.IOException;
import java.util.List;

public class SQLiteTitleReader implements TitleReader{
    @Override
    public List<Title> read() throws IOException {
        return List.of();
    }
}
