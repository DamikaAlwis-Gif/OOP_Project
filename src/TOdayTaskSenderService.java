public class TOdayTaskSenderService {
    private ITodayTaskSender todayTaskSender;

    public TOdayTaskSenderService(ITodayTaskSender todayTaskSender) {
        this.todayTaskSender = todayTaskSender;
    }
//void sendTodayTasks(String input, TaskQueryService queryService,  ReminderService reminderService,ReceiverManagerService receiverManagerService)
    void sendTodayTasks(IReceiver receiver){
        todayTaskSender.sendTodayTasks(receiver);
    }
}
