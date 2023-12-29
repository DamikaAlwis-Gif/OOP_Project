import java.time.LocalDate;

public class PersonalTask extends ATask {


    private String type ;

    public PersonalTask(String description, LocalDate date, int priority) {
        super(description,date,priority);
        type = "personal";
    }

    public PersonalTask(String description, LocalDate date) {
        super(description,date);
        type = "personal";
    }

    @Override
    public String showDetails() {
        return("Task no: " + this.getTask_id()+ "\n" +
                "Description: " + this.getDescription() + "\n" +
                "Date: " + this.getDate() + "\n" +
                "Completed :"+ this.isCompleted()+ "\n" +
                "Priority: " + this.getPriority());
    }

    @Override
    public String getType() {
        return type;
    }
}
