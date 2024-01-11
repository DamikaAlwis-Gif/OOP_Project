import java.time.LocalDate;
import java.util.ArrayList;

public class TaskQuery implements ITaskQuery {
   private ITaskRepository taskRepository;// dependency inversion
    // dependency injection by constructor
    public TaskQuery(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ArrayList<ATask> getTasksByDate(String date) {

        String[] arr = date.trim().split("-");
        ArrayList<ATask> tempArray = new ArrayList<>();
        ArrayList<ATask> taskList = taskRepository.getTaskList();

        for (ATask task : taskList) {
            if (task.getDate().equals(LocalDate.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2])))) {
                tempArray.add(task);
            }
        }
        return tempArray;

    }

    @Override
    public ATask getTaskById(int id){
        ATask tempTask = null;
        ArrayList<ATask> taskList = taskRepository.getTaskList();
        for(ATask task: taskList){
            if(task.getTask_id() == id){
                tempTask= task;
                break;
            }
        }
        return tempTask;
    }
}
