package es.ulpgc.software.Controller;

import es.ulpgc.software.Model.Title;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleReader implements TitleReader{

    private final File file;
    private final TsvDeserializer deserializer;

    public TsvTitleReader(File file) {
        this.file = file;
        this.deserializer = new TsvDeserializer();
    }

    @Override
    public List<Title> read() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            readHeaderOf(reader);
            return readAllTitlesOf(reader);

        }catch (IOException e){
            throw new IOException(e);
        }
    }

    public void readHeaderOf(BufferedReader reader) throws IOException {
        reader.readLine();
    }

    public List<Title> readAllTitlesOf(BufferedReader reader) throws IOException {
        List<Title> titles = new ArrayList<>();

        while (true){
            String line = reader.readLine();
            if (line == null) break;
            titles.add(deserializer.deserialize(line));
        }
        return titles;
    }
}
