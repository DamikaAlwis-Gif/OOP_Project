import java.util.ArrayList;
// store task objects and functions for access task repo
public class TaskRepository implements ITaskRepository {
    private static TaskRepository firstInstance = null;

    private TaskRepository(){}
    // singleton pattern used here for maintain only a one class object
    public static TaskRepository getInstance(){
        if(firstInstance == null){
            firstInstance = new TaskRepository();
        }
        return firstInstance;
    }
    private ArrayList<ATask> taskList = new ArrayList<>();
    @Override
    public ArrayList<ATask> getTaskList() {
        return taskList;
    }
    @Override
    public void Add(ATask task) {
        taskList.add(task);
    }

    public void setTaskList(ArrayList<ATask> taskList) {
        this.taskList = taskList;
    }
}
