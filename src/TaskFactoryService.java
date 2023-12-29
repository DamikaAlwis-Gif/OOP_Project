public class TaskFactoryService {
    private ITaskFactory taskFactory;

    public TaskFactoryService(ITaskFactory taskFactory) {
        this.taskFactory = taskFactory;
    }

    ATask createTask(String task_type, String task_details){
        return taskFactory.createTask(task_type,task_details );
    };
}
