package es.ulpgc.software.Controller;

import es.ulpgc.software.Model.Title;

import java.util.ArrayList;
import java.util.List;

public class TsvDeserializer implements TitleDeserializer{

    @Override
    public Title deserialize(String title) {
        String[] titleSplited = title.split("\t");
        return new Title(titleSplited[0],
                Title.TitleTypes.valueOf(capitalize(titleSplited[1])),
                titleSplited[2],
                titleSplited[3],
                isAdult(titleSplited[4]),
                isNull(titleSplited[5]),
                isNull(titleSplited[6]),
                isNull(titleSplited[7]),
                stringToGenres(titleSplited[8]) );
    }

    @Override
    public String capitalize(String word) {
        return  word.substring(0,1).toUpperCase() + word.substring(1);
    }

    public boolean isAdult(String i){
        return Integer.parseInt(i) == 0;
    }

    public List<Title.Genres> stringToGenres(String i){
        if ("\\N".equals(i)) return new ArrayList<>();

        List<Title.Genres> genres = new ArrayList<>();
        String[] genresSplited = i.split(",");

        for (String genre : genresSplited) {
            if(genre.contains("-")) {
                genres.add(Title.Genres.valueOf(genre.replace("-","_")));
                break;
            }

            genres.add(Title.Genres.valueOf(genre));
        }

        return genres;
    }


    public int isNull(String i){
        return "\\N".equals(i) ? 0 : Integer.parseInt(i);
    }
}
