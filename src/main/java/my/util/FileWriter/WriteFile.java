package my.util.FileWriter;

import my.util.properties.PropertyReader;

import java.io.IOException;
import java.util.ArrayList;

public class WriteFile {

    public void writeFile(ArrayList<String> str) {

        try (java.io.FileWriter writer =
                     new java.io.FileWriter(".\\DATA\\" + PropertyReader.readProperties().get("TableName") + ".csv", false)) {
            for (String s : str) {
                writer.write(s + "\n");
                writer.flush();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
