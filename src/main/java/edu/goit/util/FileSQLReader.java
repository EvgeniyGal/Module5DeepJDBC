package edu.goit.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

}
