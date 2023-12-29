public interface ICaseHandler {
    void handleAddingATask(String taskType);
    void handleSeeTaskDetailsById();
    void handleSendingTaskDetails();
    void handleInvalidTaskType();
    void handleSeeTaskDetailsByDate();
    void handleInvalidInput();
    String handleGettingBaseOption();
    String handleGettingTaskChoice();

}
