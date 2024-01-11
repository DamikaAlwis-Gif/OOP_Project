public class TodayTaskSenderService {
    private ITodayTaskSender todayTaskSender;

    public TodayTaskSenderService(ITodayTaskSender todayTaskSender) {
        this.todayTaskSender = todayTaskSender;
    }
//void sendTodayTasks(String input, TaskQueryService queryService,  ReminderService reminderService,ReceiverManagerService receiverManagerService)
    void sendTodayTasks(IReceiver receiver){
        todayTaskSender.sendTodayTasks(receiver);
    }
}
