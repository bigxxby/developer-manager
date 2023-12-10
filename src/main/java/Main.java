

import java.sql.*;

public class Main {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "bigxxby";
    private static Connection CONNECTION;
    private static Statement STATEMENT;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CONNECTION = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        DeveloperManager developerManager = new DeveloperManager(CONNECTION.createStatement(), CONNECTION);


    }
}
