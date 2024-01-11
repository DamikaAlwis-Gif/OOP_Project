
import java.util.ArrayList;

public class Controller {

    private TaskFactoryService taskFactoryService;
    private TaskRepositoryService taskRepositoryService;
    private DataOperationsService dataOperationsService;
    private TaskQueryService queryService;
    private TodayTaskSenderService todayTaskSenderService;
    private ReminderService reminderService;
    private ReceiverManagerService receiverManagerService;
    private TaskLoaderService taskLoaderService;

    public Controller() {
        TaskRepository taskRepository = TaskRepository.getInstance();// holds list of tasks in the applicaiton
        this.taskRepositoryService = new TaskRepositoryService(taskRepository);// create task Repo service

        TaskFactory taskFactory = new TaskFactory();// for creating new tasks
        this.taskFactoryService = new TaskFactoryService(taskFactory);

        FileOperations fileOperations = new FileOperations();// do file operations (data operations)
        this.dataOperationsService = new DataOperationsService(fileOperations);

        //loading existing tasks in the system
        TaskLoader taskLoader = new TaskLoader(taskRepositoryService , dataOperationsService);
        this.taskLoaderService = new TaskLoaderService(taskLoader);

        EmailOperations emailOperations = new EmailOperations(); // class for email operaions
        this.reminderService = new ReminderService(emailOperations);


        TaskQuery taskQuery = new TaskQuery(taskRepository);
        //create a task query service to query data from task repo
        this.queryService = new TaskQueryService(taskQuery);

        ReceiverManager receiverManager = ReceiverManager.getInstance();// class for managing receivers
        this.receiverManagerService = new ReceiverManagerService(receiverManager);

        TodayTaskSender automaticReminderOperations = new TodayTaskSender(queryService,reminderService,receiverManagerService);
        this.todayTaskSenderService = new TodayTaskSenderService(automaticReminderOperations);


    }

    public void handleSeeTaskDetailsByDate(String input) {
        ArrayList<ATask> arr = queryService.getTasksByDate(input);
        for (ATask task : arr) {
            System.out.println(task.showDetails());
            System.out.println("");
        }

    }
    public void handleSeeTaskDetailsById(int taskId){

        ATask tempTask = queryService.getTaskById(taskId);
        if (tempTask == null) {
            System.out.println("There is no task with " + taskId + ".");
        } else {
            System.out.println(tempTask.showDetails());
            System.out.println("");
        }
    }



    public void handleSendingTaskDetails(String receiverInput) {

            IReceiver receiver = receiverManagerService.createReceiver(receiverInput);
            todayTaskSenderService.sendTodayTasks(receiver);
    }

    public void handleAddingAPersonalTask(String userInput){

        // create a new task
        ATask task =taskFactoryService.createTask("personal",userInput);
        if(task != null) {
            // have to change this class to a service
            taskRepositoryService.add(task);// add a new task to the task Repo
            dataOperationsService.saveData(dataOperationsService.getPersonalTaskLocation(),userInput);// save data
        }
    }

    public void handleAddingAOfficialTask(String userInput){

        // create a new task
        ATask task =taskFactoryService.createTask("official",userInput);
        if(task != null) {
            // have to change this class to a service
            taskRepositoryService.add(task);// add a new task to the task Repo
            dataOperationsService.saveData(dataOperationsService.getOfficialTaskLocation(),userInput);// save data
        }
    }

    public void handleLoadingTasks(){
        taskLoaderService.loadTasks();
    }
    public void handleSendingTodayTaskListUser(){
        //create the current user of the application
        User user = new User("Kasun","damika7alwis@gmail.com","password123");
        todayTaskSenderService.sendTodayTasks(user);// send today tasks to the user
    }



}
