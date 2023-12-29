

public class Main {
    public static void main(String[] args) {

        TaskRepository taskRepository = new TaskRepository();// holds list of tasks in the applicaiton
        TaskRepositoryService taskRepositoryService = new TaskRepositoryService(taskRepository);// create task Repo service

        TaskFactory taskFactory = new TaskFactory();// for creating new tasks
        TaskFactoryService taskFactoryService = new TaskFactoryService(taskFactory);

        FileOperations fileOperations = new FileOperations();// do file operations (data operations)
        DataOperationsService dataOperationsService = new DataOperationsService(fileOperations);

        //loading existing tasks in the system
        TaskLoader taskLoader = new TaskLoader(taskRepositoryService , dataOperationsService);
        TaskLoaderService taskLoaderService = new TaskLoaderService(taskLoader);

        EmailOperations emailOperations = new EmailOperations(); // class for email operaions
        ReminderService reminderService = new ReminderService(emailOperations);


        TaskQuery taskQuery = new TaskQuery(taskRepository);
        //create a task query service to query data from task repo
        TaskQueryService queryService = new TaskQueryService(taskQuery);

        ReceiverManager receiverManager = new ReceiverManager();// class for managing receivers
        ReceiverManagerService receiverManagerService = new ReceiverManagerService(receiverManager);

        TodayTaskSender automaticReminderOperations = new TodayTaskSender(queryService,reminderService,receiverManagerService);
        TOdayTaskSenderService todayTaskSenderService = new TOdayTaskSenderService(automaticReminderOperations);

        ICaseHandler caseHandler = new caseHandler(taskFactoryService,taskRepositoryService,dataOperationsService,queryService, todayTaskSenderService,reminderService,receiverManagerService);
        caseHandlerService caseHandlerService = new caseHandlerService(caseHandler);


        taskLoaderService.loadTasks(); // load the existing tasks to the task Repo

        //create the current user of the application
        User user = new User("Kasun","damika7alwis@gmail.com","password123");
        todayTaskSenderService.sendTodayTasks(user);// send today tasks to the user

        System.out.println("Welcome to the Task Manager Application!");// welcome msg


        while (true) {

            try {
            String option = caseHandlerService.handleGettingBaseOption();

                switch (option) {
                    case "1":
                        String task_choice = caseHandlerService.handleGettingTaskChoice();
                        switch (task_choice) {
                            case "1":
                                caseHandlerService.handleAddingATask("personal");
                                break;
                            case "2":

                                caseHandlerService.handleAddingATask("official");
                                break;
                            default:
                                caseHandlerService.handleInvalidTaskType();
                                break;
                        }

                        break;
                    case "2":
                        caseHandlerService.handleSeeTaskDetailsByDate();
                        break;

                    case "3":
                        caseHandlerService.handleSeeTaskDetailsById();
                        break;
                    case "4":
                        caseHandlerService.handleSendingTaskDetails();
                        break;

                    default:
                       caseHandlerService.handleInvalidInput();
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }


}