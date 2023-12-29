import java.util.ArrayList;

public class TaskRepositoryService {
    private ITaskRepository repository;

    public TaskRepositoryService(ITaskRepository repository) {
        this.repository = repository;
    }

    public ArrayList<ATask> getTaskList() {
        return repository.getTaskList();
    }

    public void add(ATask task) {

        repository.Add(task);
    }

    public void setTaskList(ArrayList<ATask> taskList) {

        repository.setTaskList(taskList);
    }

}
