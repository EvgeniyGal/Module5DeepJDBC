package edu.goit.databaseutil;

import edu.goit.entity.Project;
import edu.goit.entity.Worker;
import edu.goit.util.FileSQLReader;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import java.sql.Statement;
import java.util.List;

public class DatabasePopulateService {

    public static void main(String[] args) {

        String sqlAddWorker = "INSERT INTO worker (name, birthday, level, salary) VALUES(?, ?, ?, ?);";
        String sqlAddClient = "INSERT INTO client (NAME) VALUES(?);";
        String sqlAddProject = "INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES(?,?,?);";
        String sqlNotPrepQuery = "INSERT INTO project_worker (PROJECT_ID, WORKER_ID) " +
                "SELECT p.ID, w.ID " +
                "FROM project p " +
                "CROSS JOIN (" +
                "  SELECT ID FROM worker " +
                "  ORDER BY RAND() " +
                "  LIMIT 1 + CAST(RAND() * 5 AS INT) ) w " +
                "ORDER BY p.ID;";


        try (PreparedStatement pStWorker = Database.getInstance().getConnection().prepareStatement(sqlAddWorker);
             PreparedStatement pStClient = Database.getInstance().getConnection().prepareStatement(sqlAddClient);
             PreparedStatement pStProject = Database.getInstance().getConnection().prepareStatement(sqlAddProject);
             Statement stNotPrepQuery = Database.getInstance().getConnection().createStatement()
        ) {

            workerSqlFiller(pStWorker);

            clientSqlFiller(pStClient);

            projectSqlFiller(pStProject);

            stNotPrepQuery.executeUpdate(sqlNotPrepQuery);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void projectSqlFiller(PreparedStatement pStProject) throws SQLException {

        List<Project> projects = FileSQLReader.readProjectFromFile("src/main/java/edu/goit/sql/project.txt");

        for (Project project :
                projects) {
            pStProject.setInt(1, project.getClientID());
            pStProject.setDate(2, Date.valueOf(project.getStartDate()));
            pStProject.setDate(3, Date.valueOf(project.getFinishDate()));
            pStProject.addBatch();
        }

        pStProject.executeBatch();

    }

    private static void clientSqlFiller(PreparedStatement pStClient) throws SQLException {

        List<String> strClients = FileSQLReader.readClientsFromFile("src/main/java/edu/goit/sql/client.txt");

        for (String strClient :
                strClients) {
            pStClient.setString(1, strClient);
            pStClient.addBatch();
        }

        pStClient.executeBatch();

    }

    private static void workerSqlFiller(PreparedStatement pStWorker) throws SQLException {

        List<Worker> workers = FileSQLReader.readWorkersFromFile("src/main/java/edu/goit/sql/workers.txt");

        for (Worker worker :
                workers) {
            pStWorker.setString(1, worker.getName());
            pStWorker.setDate(2, Date.valueOf(worker.getBirthday()));
            pStWorker.setString(3, worker.getLevel());
            pStWorker.setInt(4, worker.getSalary());
            pStWorker.addBatch();
        }

        pStWorker.executeBatch();

    }

}
