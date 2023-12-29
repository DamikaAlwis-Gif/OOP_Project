public class TaskLoaderService {

    private ITaskLoader taskLoader;

    public TaskLoaderService(ITaskLoader taskLoader) {
        this.taskLoader = taskLoader;
    }
    public void loadTasks(){
        taskLoader.loadTasks();
    }
}
