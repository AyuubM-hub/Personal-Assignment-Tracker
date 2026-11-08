import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            Connection connection = DatabaseConnection.getConnection();
            System.out.println("Database connection established successfully.");

            connection.close();

        }
        catch (SQLException e) {
            System.out.println("Failed to establish database connection:");
            e.printStackTrace();
        }
    }
}