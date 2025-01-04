package es.ulpgc.software.Controller;

import es.ulpgc.software.Model.Histogram;
import es.ulpgc.software.Model.Title;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TitleTypeHistogram implements Histogram {

    private final Map<Title.TitleTypes, Long> histogram;

    public TitleTypeHistogram(List<Title> titles) {
        this.histogram = createHistogram(titles);
    }

    private Map<Title.TitleTypes, Long> createHistogram(List<Title> titles) {
        return titles.stream()
                .collect(Collectors.groupingBy(Title::titleType, Collectors.counting()));
    }

    public Long valueOf(String type) {
        Title.TitleTypes titleTypes = Title.TitleTypes.valueOf(type);
        return histogram.get(titleTypes);
    }

    public List<String> getKeys(){
        return histogram.keySet().stream()
                .map(Title.TitleTypes::toString)
                .toList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Title.TitleTypes titleType : Title.TitleTypes.values()) {
            long count = histogram.get(titleType) % 100000;
            sb.append(titleType)
                    .append(": ")
                    .append("|".repeat((int) count))
                    .append("\n");
        }
        return sb.toString();
    }

}
