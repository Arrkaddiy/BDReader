package my.util;

import my.util.DBReader.DBManager;
import my.util.FileWriter.WriteFile;

import java.sql.SQLException;

public class Manager {

    DBManager dbManager = new DBManager();
    WriteFile writeFile = new WriteFile();

    public void writeFileFromDB() throws SQLException, ClassNotFoundException {

        writeFile.writeFile(dbManager.dbRD());

    }
}
