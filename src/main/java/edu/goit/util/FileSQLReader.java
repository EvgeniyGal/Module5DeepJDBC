package edu.goit.util;

import edu.goit.entity.Project;
import edu.goit.entity.Worker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileSQLReader {

    public static String readFromFile(String location) {
        StringBuilder stringBuffer = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(location))) {
            while (reader.ready()) {
                stringBuffer.append(reader.readLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }

    public static List<Worker> readWorkersFromFile(String location) {

        List<Worker> workers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(location))) {
            while (reader.ready()) {
                String strLine = reader.readLine();
                strLine = strLine.replaceAll("[(');]", "");
                String[] strWorkerData = strLine.trim().split(",\\s*|,");
                Worker worker = Worker.builder()
                        .name(strWorkerData[0])
                        .birthday(LocalDate.parse(strWorkerData[1]))
                        .level(strWorkerData[2])
                        .salary(Integer.parseInt(strWorkerData[3]))
                        .build();
                workers.add(worker);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return workers;
    }

    public static List<String> readClientsFromFile(String location) {

        List<String> clients = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(location))) {
            while (reader.ready()) {
                clients.add(reader.readLine().replaceAll("[^a-zA-Z\\s]+", ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clients;
    }

    public static List<Project> readProjectFromFile(String location) {

        List<Project> projects = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(location))) {
            while (reader.ready()) {
                String strLine = reader.readLine();
                strLine = strLine.replaceAll("[(');]", "");
                String[] strProjectData = strLine.trim().split(",\\s*|,");
                Project project = Project.builder()
                        .clientID(Integer.parseInt(strProjectData[0]))
                        .startDate(LocalDate.parse(strProjectData[1]))
                        .finishDate(LocalDate.parse(strProjectData[2]))
                        .build();
                projects.add(project);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return projects;
    }

}
