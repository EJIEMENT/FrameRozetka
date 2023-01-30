package database;

import java.sql.*;

public class DbHandler {
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "OLE1189567kon!";
    private static final String DB_NAME = "mentorship";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;


    public static Connection getDbConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public static void executeSecondTask() {
        DbHandler dbHandler = new DbHandler();
        System.out.println("Task 2:");

        try (Connection connection = dbHandler.getDbConnection(); Statement stmt = connection.createStatement();) {
            stmt.addBatch("INSERT INTO newiteminrozetkastore VALUES(007,'Phone',12000,'Ukraine','yes')");
            stmt.addBatch("INSERT INTO newiteminrozetkastore VALUES(008,'Notebook',24000,'Poland','no')");
            stmt.executeBatch();
            System.out.println("Done");
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public static void executeThirdTask() {
        DbHandler dbHandler = new DbHandler();
        System.out.println("Task 3:");

        try (Connection connection = dbHandler.getDbConnection();
             Statement stmt = connection.createStatement();) {
            stmt.addBatch("UPDATE newiteminrozetkastore SET Price=10000 WHERE id=8");
            stmt.addBatch("UPDATE newiteminrozetkastore SET Country='Ukraine' WHERE id=8");
            stmt.addBatch("UPDATE newiteminrozetkastore SET Delivery='yes' WHERE id=8");
            stmt.executeBatch();
            System.out.println("Done");
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public static void showTables() {
        DbHandler dbHandler = new DbHandler();
        System.out.println("Task 4:");
        try (Connection connection = dbHandler.getDbConnection(); Statement stmt = connection.createStatement();) {
            ResultSet str = stmt.executeQuery("SELECT * FROM newiteminrozetkastore;");
            while (str.next()) {
                System.out.println(str.getString(1) + " " + str.getString(2));
            }
            System.out.println("Done");
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
}




