package my.util.DBReader;

import my.util.properties.PropertyReader;

import java.sql.SQLException;
import java.util.ArrayList;

public class DBManager {

    DBDAO dbdao = new DBDAO();


    private String sql = "Select * from '" + PropertyReader.readProperties().get("TableName") + "';";

    public ArrayList<String> dbRD() throws ClassNotFoundException, SQLException {

        ArrayList<String> str;

        dbdao.openDB();
        str = dbdao.selcetDB(sql);
        dbdao.closeDB();

        return str;
    }
}
