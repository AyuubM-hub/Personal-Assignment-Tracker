import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentManager { 
    
    public void addAssignment(Assignment assignment) 
            throws SQLException {

        String sql = """
            INSERT INTO assignments 
            (title, description, deadline, priority, completed, module_id)
            VALUES (?, ?, ?, ?, ?, ?)
            """;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, assignment.getTitle());
            statement.setString(2, assignment.getDescription());
            statement.setDate(3, Date.valueOf(assignment.getDeadline()));
            statement.setString(4, assignment.getPriority());
            statement.setBoolean(5, assignment.isCompleted());
            statement.setInt(6, assignment.getModuleId());

            statement.executeUpdate();
            System.out.println("Assignment added successfully.");
       } 
    }

    public List<Assignment> getAllAssignments()
        throws SQLException {

            List<Assignment> assignments = new ArrayList<>();

            String sql = "SELECT * FROM assignments ORDER BY deadline";

            try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet result = statement.executeQuery()) {
                    while (result.next()) {
                        
                        Assignment assignment = new Assignment(
                            result.getInt("assignment_id"),
                            result.getString("title"),
                            result.getString("description"),
                            result.getDate("deadline").toLocalDate(),
                            result.getString("priority"),
                            result.getBoolean("completed"),
                            result.getInt("module_id")
                        );
                        assignments.add(assignment);
                    }
                } 
                return assignments;
        }
            
            public void updateAssignment(Assignment assignment) 
                throws SQLException {
                    String sql = """
                        UPDATE assignments
                        SET title = ?, description = ?, deadline = ?, priority = ?, completed = ?, module_id = ?
                        WHERE assignment_id = ?
                        """;
                    try (Connection connection = DatabaseConnection.getConnection();
                         PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, assignment.getTitle());
                        statement.setString(2, assignment.getDescription());
                        statement.setDate(3, Date.valueOf(assignment.getDeadline()));
                        statement.setString(4, assignment.getPriority());
                        statement.setBoolean(5, assignment.isCompleted());
                        statement.setInt(6, assignment.getModuleId());
                        statement.setInt(7, assignment.getAssignmentId());

                        int rowsAffected = statement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Assignment updated successfully.");
                        } else {
                            System.out.println("No assignment found with the given ID.");
                        }
                    }
                }
            public void deleteAssignment(int assignmentId)
                throws SQLException{

                String sql = """
                    DELETE FROM assignments
                    WHERE assignment_id = ?
                    """;
                
                try (Connection connection = DatabaseConnection.getConnection();
                     PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, assignmentId);
                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Assignment deleted successfully.");
                    } else {
                        System.out.println("No assignment found with the given ID.");
                    }
                } 
            }
    }