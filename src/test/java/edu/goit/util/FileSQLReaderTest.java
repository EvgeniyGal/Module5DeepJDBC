package edu.goit.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileSQLReaderTest {

    @Test
    void readFromFileTest() {
        String actual = FileSQLReader.readFromFile("src/main/java/edu/goit/sql/init_db.sql");
        String expected = "CREATE TABLE worker (\n" +
                "  ID INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "  NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000),\n" +
                "  BIRTHDAY DATE CHECK (BIRTHDAY >= '1900-01-01'),\n" +
                "  LEVEL VARCHAR(10) NOT NULL CHECK (LEVEL IN ('Trainee', 'Junior', 'Middle', 'Senior')),\n" +
                "  SALARY INT CHECK (SALARY >= 100 AND SALARY <= 100000)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE client (\n" +
                "  ID INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "  NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE project (\n" +
                "  ID INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "  CLIENT_ID INT NOT NULL,\n" +
                "  START_DATE DATE,\n" +
                "  FINISH_DATE DATE,\n" +
                "  FOREIGN KEY (CLIENT_ID) REFERENCES client(ID)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE project_worker (\n" +
                "  PROJECT_ID INT NOT NULL,\n" +
                "  WORKER_ID INT NOT NULL,\n" +
                "  PRIMARY KEY (PROJECT_ID, WORKER_ID),\n" +
                "  FOREIGN KEY (PROJECT_ID) REFERENCES project(ID),\n" +
                "  FOREIGN KEY (WORKER_ID) REFERENCES worker(ID)\n" +
                ");\n";

        Assertions.assertEquals(expected, actual);
    }
}