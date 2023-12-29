import java.util.ArrayList;

public interface ITaskQuery {
    ArrayList<ATask> getTasksByDate(String date);
    ATask getTaskById(int id);
}
