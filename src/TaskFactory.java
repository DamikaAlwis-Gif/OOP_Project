import java.time.LocalDate;
import java.util.ArrayList;

public class TaskFactory implements ITaskFactory {


    // factory design pattern used to create Task objects
    @Override
    public ATask createTask(String task_type, String task_details) {


        String[] list = task_details.split(",");
        String[] temp = list[1].trim().split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));

        ATask task = null;
        switch (task_type) {
            case "personal":

                if (list.length == 2) {
                    task = new PersonalTask(list[0], date);
                } else {
                    task = new PersonalTask(list[0], date, Integer.parseInt(list[2]));
                }

                System.out.println("Personal task created");

                break;

            case "official":

                if (list.length == 4) {
                    task = new OfficialTask(list[0], date, list[2], list[3]);
                } else {
                    task = new OfficialTask(list[0], date, list[2], list[3], Integer.parseInt(list[4]));
                }

                System.out.println("Official task created");

                break;
            default:
                System.out.println("Invalid task type!");
                break;



        }
        return task;

    }
}
