public class caseHandlerService {
    private ICaseHandler caseHandler;

    public caseHandlerService(ICaseHandler caseHandler) {
        this.caseHandler = caseHandler;
    }

    public void handleAddingATask(String taskType){
        caseHandler.handleAddingATask(taskType);
    }
    void handleInvalidTaskType(){
        caseHandler.handleInvalidInput();
    }
    void handleSeeTaskDetailsByDate(){
        caseHandler.handleSeeTaskDetailsByDate();
    }
    void handleSeeTaskDetailsById(){
        caseHandler.handleSeeTaskDetailsById();
    }
    void handleSendingTaskDetails(){
        caseHandler.handleSendingTaskDetails();
    }

    void handleInvalidInput(){
        caseHandler.handleInvalidInput();
    }
    public String handleGettingBaseOption(){
        return caseHandler.handleGettingBaseOption();
    }
    public String handleGettingTaskChoice(){
        return caseHandler.handleGettingTaskChoice();
    }



}
