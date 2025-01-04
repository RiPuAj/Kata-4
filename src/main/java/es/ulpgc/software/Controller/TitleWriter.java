package es.ulpgc.software.Controller;

import es.ulpgc.software.Model.Title;

import java.sql.SQLException;

public interface TitleWriter {
    void writeTitle(Title title) throws SQLException;
}
