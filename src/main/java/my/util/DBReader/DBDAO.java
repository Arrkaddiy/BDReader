package my.util.DBReader;

import my.util.properties.PropertyReader;

import java.sql.*;
import java.util.ArrayList;


public class DBDAO {

    private static Connection conn = null;
    private static Statement statmt = null;
    private static ResultSet resSet = null;

    public void openDB() throws ClassNotFoundException {

        try {
            conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:DataBase/chinook.db");
            System.out.println("База Подключена!");
        } catch (SQLException e) {
            System.err.println("Ошибка подключения!");
        }
    }

    public ArrayList<String> selcetDB(String sql) throws SQLException {

        ArrayList<String> str = new ArrayList<>();

        if (statmt == null) { statmt = conn.createStatement(); }
        resSet = statmt.executeQuery(sql);

        while (resSet.next()) {

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 1; i <= resSet.getMetaData().getColumnCount(); i++) {

                stringBuilder.append(resSet.getObject(i)).append(";");
            }
            str.add(stringBuilder.toString());
        }
        System.out.println("Считывание из таблицы " + PropertyReader.readProperties().get("TableName") + " завершено. Считано: " + str.size());
        return str;
    }

    public void closeDB() throws SQLException {
        if(conn != null)
            conn.close();

        if(statmt != null)
            statmt.close();

        if(resSet!= null)
            resSet.close();

        System.out.println("Соединения закрыты!");
    }

}
