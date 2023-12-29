import java.time.LocalDate;

public abstract class ATask {
    private final int task_id;
    private String description;
    private int priority ;
    private boolean completed ;
    private LocalDate date;
    private static int count = 0;


    public ATask(String description, LocalDate date, int priority) {
        this.description = description;
        this.priority = priority;
        this.date = date;
        completed = false;
        count++;
        task_id = count;
    }

    public ATask(String description, LocalDate date) {
        this.description = description;
        this.date = date;
        this.priority = 3; // default priority
        completed = false;
        count++;
        task_id = count;
    }


    public abstract String showDetails();


    public String getDescription() {
        return description;
    }


    public int getPriority() {
        return priority;
    }


    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTask_id() {
        return task_id;
    }


    public void setCompleted(boolean val) {
        completed = val;
    }

    public abstract String getType();
}
