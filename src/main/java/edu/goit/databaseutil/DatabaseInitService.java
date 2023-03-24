package edu.goit.databaseutil;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class DatabaseInitService {

    public static void main(String[] args) {

        String sqlWorker = "CREATE TABLE worker (" +
                "  ID INT AUTO_INCREMENT PRIMARY KEY," +
                "  NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= ? AND LENGTH(NAME) <= ?)," +
                "  BIRTHDAY DATE CHECK (BIRTHDAY >= ?)," +
                "  LEVEL VARCHAR(10) NOT NULL CHECK (LEVEL IN (?, ?, ?, ?))," +
                "  SALARY INT CHECK (SALARY >= ? AND SALARY <= ?));";

        String sqlClient = "CREATE TABLE client (" +
                "  ID INT AUTO_INCREMENT PRIMARY KEY," +
                "  NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= ? AND LENGTH(NAME) <= ?));";

        String sqlProdWork = "CREATE TABLE project (" +
                "  ID INT AUTO_INCREMENT PRIMARY KEY," +
                "  CLIENT_ID INT NOT NULL," +
                "  START_DATE DATE," +
                "  FINISH_DATE DATE," +
                "  FOREIGN KEY (CLIENT_ID) REFERENCES client(ID)); " +
                "CREATE TABLE project_worker (" +
                "  PROJECT_ID INT NOT NULL," +
                "  WORKER_ID INT NOT NULL," +
                "  PRIMARY KEY (PROJECT_ID, WORKER_ID)," +
                "  FOREIGN KEY (PROJECT_ID) REFERENCES project(ID)," +
                "  FOREIGN KEY (WORKER_ID) REFERENCES worker(ID));";

        int maxNameLength = 1000;
        int minNameLength = 2;
        int minSalary = 100;
        int maxSalary = 100000;
        String startDate = "1900-01-01";
        List<String> levels = Arrays.asList("Trainee", "Junior", "Middle", "Senior");

        try (PreparedStatement pStWorker = Database.getInstance().getConnection().prepareStatement(sqlWorker);
             PreparedStatement pStClient = Database.getInstance().getConnection().prepareStatement(sqlClient);
             Statement stProdWork = Database.getInstance().getConnection().createStatement()) {

            pStWorker.setInt(1, minNameLength);
            pStWorker.setInt(2, maxNameLength);
            pStWorker.setString(3, startDate);
            for (int i = 4; i < 8; i++) {
                pStWorker.setString(i, levels.get(i - 4));
            }
            pStWorker.setInt(8, minSalary);
            pStWorker.setInt(9, maxSalary);
            pStWorker.executeUpdate();

            pStClient.setInt(1, minNameLength);
            pStClient.setInt(2, maxNameLength);
            pStClient.executeUpdate();

            stProdWork.executeUpdate(sqlProdWork);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
