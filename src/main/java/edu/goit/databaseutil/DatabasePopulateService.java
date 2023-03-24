package edu.goit.databaseutil;

import edu.goit.util.FileSQLReader;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {

    public static void main(String[] args) {

        try (Statement statement = Database.getInstance().getConnection().createStatement()) {
            statement.executeUpdate(FileSQLReader.readFromFile("src/main/java/edu/goit/sql/populate_db.sql"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
