package es.ulpgc.software.Model;

import java.util.List;

public interface Histogram {
    List<String> getKeys();
    Long valueOf(String type);
}
