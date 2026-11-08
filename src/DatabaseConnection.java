import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/assignment_tracker";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = 
        System.getenv("DB_PASSWORD"); // Retrieve the password from an environment variable

    public static Connection getConnection() throws SQLException {
        if (PASSWORD == null || PASSWORD.isBlank()) {
            throw new SQLException("Database password is not set in the environment variable.");
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
};