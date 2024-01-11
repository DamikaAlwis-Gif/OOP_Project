import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();

        ConsoleOperations consoleOperations = new ConsoleOperations(scanner);
        ConsoleServices consoleServices = new ConsoleServices(consoleOperations);// handle console inputs and outputs

        controller.handleLoadingTasks();
        controller.handleSendingTodayTaskListUser();

        consoleServices.showWelcomeMessage();

        while (true) {

            try {

                String option = consoleServices.getBaseOptionType();
                switch (option) {

                    case "1":

                        String task_choice = consoleServices.getTaskType();

                        switch (task_choice) {
                            case "1":
                                String personalTaskDetail = consoleServices.getPersonalTaskDetails(); // get the input
                                controller.handleAddingAPersonalTask(personalTaskDetail);
                                break;
                                
                            case "2":

                                String officialTaskDetail = consoleServices.getOfficialTaskDetails(); // get the input
                                controller.handleAddingAOfficialTask(officialTaskDetail);
                                break;

                            default:
                                consoleServices.showInvalidTaskTypeMessage();
                                break;
                        }

                        break;
                    case "2":
                        String dateInput = consoleServices.getDateInput(); // getting inputs
                        controller.handleSeeTaskDetailsByDate(dateInput);
                        break;

                    case "3":

                        int id = consoleServices.getIDInput();
                        controller.handleSeeTaskDetailsById(id);

                        break;
                    case "4":
                        String receiverDetailInput = consoleServices.getReceiverDetails();
                        controller.handleSendingTaskDetails(receiverDetailInput);
                        break;

                    default:
                       consoleServices.showInvalidInputMessage();
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }


}