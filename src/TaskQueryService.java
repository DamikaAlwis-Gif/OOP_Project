import java.util.ArrayList;

public class TaskQueryService {
    ITaskQuery taskQuery ;

    public TaskQueryService(ITaskQuery taskQuery) {
        this.taskQuery = taskQuery;
    }

    public ArrayList<ATask> getTasksByDate(String date){
        return taskQuery.getTasksByDate(date);
    }
    public ATask getTaskById(int id){
        return taskQuery.getTaskById(id);
    }
}
