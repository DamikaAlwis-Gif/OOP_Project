import java.time.LocalDate;

public class OfficialTask extends ATask implements IOfficialItem {

    private  String type;
    private String project;
    private String status;

    public OfficialTask(String description, LocalDate date, String project, String status, int priority) {
        super(description, date, priority);
        this.status = status;
        this.project = project;
        type = "official"; // set the type
    }

    public OfficialTask(String description, LocalDate date , String project, String status) {
        super(description,date);
        this.status = status;
        this.project = project;
        type = "official"; // set the type

    }

    @Override
    public String showDetails() {
        return("Task no: " + this.getTask_id()+ "\n" +
                "Description: " + this.getDescription()+ "\n" +
                "Date: " + this.getDate() + "\n" +
                "Project: " + project + "\n" +
                "Status: " + status + "\n" +
                "Completed :"+ this.isCompleted()+ "\n" +
                "Priority: " + this.getPriority());
    }


    public String getType() {
        return type;
    }

    @Override
    public String getProject() {
        return project;
    }

    @Override
    public String getStatus() {
        return status;
    }
}
