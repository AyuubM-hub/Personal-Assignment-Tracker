import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AssignmentManager manager = new AssignmentManager();

        Assignment assignment = new Assignment(
            0,
            "Complete Java Project",
            "Finish the Java project for the assignment tracker.",
            LocalDate.of(2024, 6, 30),
            "High",
            false,
            1
        );

        try{
             manager.addAssignment(assignment);

             List<Assignment> assignments = manager.getAllAssignments();

             System.out.println("\n All Assignments:");

             for (Assignment a: assignments) {
                System.out.println("Title: " + a.getTitle());
                System.out.println("Description: " + a.getDescription());
                System.out.println("Deadline: " + a.getDeadline());
                System.out.println("Priority: " + a.getPriority());
                System.out.println("Completed: " + a.isCompleted());
                System.out.println("-----------");
             }
        }
        catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }
}