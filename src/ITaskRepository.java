import java.util.ArrayList;

public interface ITaskRepository {

    void Add(ATask task);
    ArrayList<ATask> getTaskList();
    void setTaskList(ArrayList<ATask> taskList);

}
