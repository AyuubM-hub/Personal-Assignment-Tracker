import java.time.LocalDate;

public class Assignment {
    
    private int assignmentId;
    private String title;
    private String description;
    private LocalDate deadline;
    private String priority;
    private boolean completed;
    private int moduleId;

    public Assignment(
        int assignmentId,
        String title,
        String description,
        LocalDate deadline,
        String priority,
        boolean completed,
        int moduleId) {
    
        this.assignmentId = assignmentId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.completed = completed;
        this.moduleId = moduleId;

        }
        public int getAssignmentId() {
    return assignmentId;
}

public String getTitle() {
    return title;
}

public String getDescription() {
    return description;
}

public LocalDate getDeadline() {
    return deadline;
}

public String getPriority() {
    return priority;
}

public boolean isCompleted() {
    return completed;
}

public int getModuleId() {
    return moduleId;
}
}