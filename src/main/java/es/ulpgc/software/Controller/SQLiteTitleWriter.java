package es.ulpgc.software.Controller;

import es.ulpgc.software.Model.Title;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class SQLiteTitleWriter implements TitleWriter {
    private static final String createTableStatement = "CREATE TABLE IF NOT EXISTS CREATE TABLE movies (" +
            "id TEXT PRIMARY KEY," +
            "titleType TEXT NOT NULL," +
            "primaryTitle TEXT NOT NULL," +
            "originalTitle TEXT NOT NULL," +
            "isAdult BOOLEAN NOT NULL," +
            "startYear INTEGER," +
            "endYear INTEGER," +
            "runtimeMinutes INTEGER," +
            "genres TEXT )";

    private static final String insertStatement = "INSERT INTO movies VALUES(?,?,?,?,?,?)";
    private final String databaseUrl;
    private final Connection connection;
    private final PreparedStatement statement;

    public SQLiteTitleWriter(File file) throws SQLException {
        this.databaseUrl = "jdbc:sqlite:" + file.getAbsolutePath();
        this.connection = DriverManager.getConnection(databaseUrl);
        this.statement = initialStatement();
    }

    private PreparedStatement initialStatement() throws SQLException {
        this.connection.createStatement().execute(createTableStatement);
        return this.connection.prepareStatement(insertStatement);
    }

    @Override
    public void writeTitle(Title title) throws SQLException {
        statement.setString(1, title.id());
        statement.setString(2, String.valueOf(title.titleType()));
        statement.setString(3, title.primaryTitle());
        statement.setString(4, title.originalTitle());
        statement.setBoolean(5, title.isAdult());
        statement.setInt(6, title.startYear());
        statement.setInt(7, title.endYear());
        statement.setInt(8, title.runtimeMinutes());
        statement.setString(9, title.genres().stream()
                .map(Enum::name).collect(Collectors.joining(",")));


    }
}
