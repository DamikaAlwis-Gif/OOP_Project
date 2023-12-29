
import java.util.ArrayList;
import java.util.Scanner;

public class caseHandler implements ICaseHandler{
    private Scanner scanner = new Scanner(System.in);
    private TaskFactoryService taskFactoryService;
    private TaskRepositoryService taskRepositoryService;
    private DataOperationsService dataOperationsService;
    private TaskQueryService queryService;
    private TOdayTaskSenderService TOdayTaskSenderService;
    private ReminderService reminderService;
    private ReceiverManagerService receiverManagerService;

    public caseHandler(TaskFactoryService taskFactoryService, TaskRepositoryService taskRepositoryService, DataOperationsService dataOperationsService, TaskQueryService queryService, TOdayTaskSenderService TOdayTaskSenderService, ReminderService reminderService, ReceiverManagerService receiverManagerService) {
        this.taskFactoryService = taskFactoryService;
        this.taskRepositoryService = taskRepositoryService;
        this.dataOperationsService = dataOperationsService;
        this.queryService = queryService;
        this.TOdayTaskSenderService = TOdayTaskSenderService;
        this.reminderService = reminderService;
        this.receiverManagerService = receiverManagerService;
    }
    @Override
    public void handleAddingATask(String taskType) {
        boolean valid = false;
        String location = null;
        switch (taskType){
            case "personal":
                valid = true;
                System.out.print("Use this format for your input \n" +
                        "<Description>,<Scheduled  Date>,<Priority> or <Description>,<Scheduled  Date> \n" +
                        ":");
                location = dataOperationsService.getPersonalTaskLocation();
                break;
            case "official":
                valid = true;
                System.out.print("Use this format for your input \n" +
                        "<Description>,<Scheduled  Date>,<Project>,<Status>,<Priority> or \n" + "<Description>,<Scheduled  Date><Project>,<Status> \n" +
                        ":");
                location = dataOperationsService.getOfficialTaskLocation();
                break;
            default:
                System.out.println("Invalid Task Type");
                break;
        }
        if(valid){
            scanner.nextLine();
            if(scanner.hasNextLine()){
                String personalTaskDetail = scanner.nextLine(); // get the input

                // create a new task
                ATask task =taskFactoryService.createTask(taskType,personalTaskDetail);
                if(task != null) {
                    // have to change this class to a service
                    taskRepositoryService.add(task);// add a new task to the task Repo
                    dataOperationsService.saveData(location,personalTaskDetail);// save data
                }


            }

        }

    }
    @Override
    public void handleInvalidTaskType(){
        System.out.println("Invalid Input");
    }

    @Override
    public void handleSeeTaskDetailsByDate() {
        System.out.print("Enter a date:");
        String input = scanner.next(); // getting inputs

        ArrayList<ATask> arr = queryService.getTasksByDate(input);
        for (ATask task : arr) {
            System.out.println(task.showDetails());
            System.out.println("");
        }

    }
    public void handleSeeTaskDetailsById(){
        System.out.print("Enter task id:");
        int taskId = scanner.nextInt();// getting inputs
        ATask tempTask = queryService.getTaskById(taskId);
        if (tempTask == null) {
            System.out.println("There is no task with " + taskId + ".");
        } else {
            System.out.println(tempTask.showDetails());
            System.out.println("");
        }
    }


    @Override
    public void handleSendingTaskDetails() {
        System.out.print("Use this format for your input \n" +
                "<name>,<email> \n" +
                ":");
        scanner.nextLine();
        if(scanner.hasNextLine()){
            String receiverInput = scanner.nextLine();// getting inputs
            IReceiver receiver = receiverManagerService.createReceiver(receiverInput);

            TOdayTaskSenderService.sendTodayTasks(receiver);
        }

    }
    public void handleInvalidInput(){
        System.out.println("Invalid input!");
    }

    public String handleGettingBaseOption(){
        System.out.print(
                "1 - Adding a new Task.\n" +
                        "2 - See task list on a date.\n" +
                        "3 - See task details by task id.\n" +
                        "4 - Send task list to a another person.\n"+
                        "Enter your option type:");

        String option = scanner.next();
        return option;
    }

    public String handleGettingTaskChoice(){
        System.out.print("1 - Personal task \n" +
                "2 - Official Task \n" +
                "Enter your choice:");
        String task_choice = scanner.next();
        return task_choice;
    }

}
