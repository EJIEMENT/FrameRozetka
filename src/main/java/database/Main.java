package database;

public class Main {
    public static void main(String[] args) {
        DbHandler.getDbConnection();
//        DbHandler.executeSecondTask();
//        DbHandler.executeThirdTask();
        DbHandler.showTables();
    }

}
