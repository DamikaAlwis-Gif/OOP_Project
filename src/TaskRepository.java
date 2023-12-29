import java.util.ArrayList;

public class TaskRepository implements ITaskRepository {
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
