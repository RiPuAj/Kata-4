package es.ulpgc.software.Model;

import java.util.List;

public record Title(String id,
                    TitleTypes titleType,
                    String primaryTitle,
                    String originalTitle,
                    boolean isAdult,
                    int startYear,
                    int endYear,
                    int runtimeMinutes,
                    List<Genres> genres) {

    public enum TitleTypes {
        VideoGame,
        TvPilot,
        Movie,
        TvSeries,
        TvMiniSeries,
        Short,
        TvSpecial,
        TvShort,
        Video,
        TvMovie,
        TvEpisode
    }

    public enum Genres {
        Action,
        Adult,
        Adventure,
        Animation,
        Biography,
        Comedy,
        Crime,
        Documentary,
        Drama,
        Family,
        Fantasy,
        Film_Noir,
        Game_Show,
        History,
        Horror,
        Musical,
        Music,
        Mystery,
        News,
        Reality_TV,
        Romance,
        Sci_Fi,
        Short,
        Sport,
        Talk_Show,
        Thriller,
        War,
        Western
    }
}
