import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        AssignmentManager manager = new AssignmentManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while(running) {

            System.out.println("\n Assignment Tracker Menu");
            System.out.println("1. Add an assignment");
            System.out.println("2. View all assignments");
            System.out.println("3. Update an assignment");
            System.out.println("4. Delete an assignment");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try{
                switch (choice) {
                    
                    case 1: System.out.println("Add assignment selected"); 
                            System.out.println("Enter title: ");
                            String title = scanner.nextLine();

                            if(title.trim().isEmpty()) {
                                System.out.println("Title cannot be empty. Assignment not added.");
                            break;
                            }
                            
                            System.out.println("Enter description: ");
                            String description = scanner.nextLine();

                            if(description.trim().isEmpty()) {
                                System.out.println("Description cannot be empty. Assignment not added.");
                            break;
                            }
                            System.out.println("Enter deadline (YYYY-MM-DD): ");
                            LocalDate deadline = LocalDate.parse(scanner.nextLine());
                            
                            System.out.println("Enter priority: ");
                            String priority = scanner.nextLine();

                                if (!priority.equalsIgnoreCase("Low")
                                && !priority.equalsIgnoreCase("Medium")
                                && !priority.equalsIgnoreCase("High")) {
                                System.out.println("Invalid priority.");
                            break;
    }

                            System.out.println("Enter module ID: ");
                            int moduleId = scanner.nextInt();
                            scanner.nextLine();

                            Assignment newAssignment = new Assignment(
                                0,
                                title,
                                description,
                                deadline,
                                priority,
                                false,
                                moduleId
                            );
                            manager.addAssignment(newAssignment);
                            System.out.println("Assignment added successfully.")
                        ;
                    break;
                    case 2: System.out.println("Your assignments");
                        for (Assignment a : manager.getAllAssignments()) {
                            System.out.println(a.getAssignmentId() + ": " + a.getTitle() + " - " + a.getDeadline() + " - " + a.getPriority());

                        }
                        break;
                    case 3: System.out.println("Update assignment selected");
                            System.out.println("Enter the assignment ID to update:");
                            int assignmentId = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter new title:");
                            String newTitle = scanner.nextLine();

                            System.out.println("Enter new description:");
                            String newDescription = scanner.nextLine();

                            System.out.println("Enter new deadline (YYYY-MM-DD):");
                            LocalDate newDeadline = LocalDate.parse(scanner.nextLine());

                            System.out.println("Enter new priority:");
                            String newPriority = scanner.nextLine();

                            System.out.println("Is the assignment completed? (true/false):");
                            boolean completed = scanner.nextBoolean();
                            scanner.nextLine();

                            Assignment updatedAssignment = new Assignment(
                                assignmentId,
                                newTitle,
                                newDescription,
                                newDeadline,
                                newPriority,
                                completed,
                                1 
                            );

                            manager.updateAssignment(updatedAssignment);
                            System.out.println("Assignment updated successfully.");
                        break;
                    case 4: System.out.println("Your current assignments:");

                            List<Assignment> assignments = manager.getAllAssignments();

                            if (assignments.isEmpty()) {
                                System.out.println("No assignments available to delete.");
                                break;
                            }

                            for (Assignment a : assignments) {
                                System.out.println(
                                    "ID: " + a.getAssignmentId()
                                    + " | Title: " + a.getTitle()
                                );
                            }
                    
                            System.out.println("Enter the ID of the assignment to be deleted");
                            int deleteId;
                            // scanner.nextLine();

                            try {
                                deleteId = Integer.parseInt(scanner.nextLine());

                                if (deleteId < 1) {
                                    System.out.println("Invalid ID. Please enter a positive integer.");
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid integer.");
                                break;
                            }

                            boolean found = false;

                            for (Assignment a : assignments) {
                                if (a.getAssignmentId() == deleteId) {
                                    found = true;
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("Assignment with ID " + deleteId + " not found.");
                                break;
                            }

                            System.out.println("Are you sure you want to delete assignment with ID " + deleteId + "? (yes/no)");
                            String confirmation = scanner.nextLine();
                            if (confirmation.equalsIgnoreCase("yes")) {
                                manager.deleteAssignment(deleteId);
                                System.out.println("Assignment deleted successfully.");
                            } else {
                                System.out.println("Assignment deletion cancelled.");
                            }
                        break;
                    case 5: running = false; 
                        System.out.println("Exiting menu. Goodbye!");
                        break;
                    default: System.out.println("Invalid option. Please try again.");
                }
            }

            catch (SQLException e) {
                System.out.println("Database error occurred.");
                e.printStackTrace();
            }
        }
        scanner.close();
        }
}