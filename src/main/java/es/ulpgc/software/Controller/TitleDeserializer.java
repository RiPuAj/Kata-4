package es.ulpgc.software.Controller;

import es.ulpgc.software.Model.Title;

public interface TitleDeserializer {
    Title deserialize(String title);
    String capitalize(String word);
}
