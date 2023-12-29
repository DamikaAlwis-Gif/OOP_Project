import java.time.LocalDate;
import java.util.ArrayList;

public class TodayTaskSender implements ITodayTaskSender {

    private TaskQueryService queryService;
    private ReminderService reminderService;
    private ReceiverManagerService receiverManagerService;

    public TodayTaskSender(TaskQueryService queryService, ReminderService reminderService, ReceiverManagerService receiverManagerService) {
        this.queryService = queryService;
        this.reminderService = reminderService;
        this.receiverManagerService = receiverManagerService;
    }

    public void sendTodayTasks(IReceiver receiver) {

        ArrayList<ATask> todayTaskList = queryService.getTasksByDate(LocalDate.now().toString());
        String subject = "Today's tasks";
        String content ="";
        if(!todayTaskList.isEmpty()){

            for(ATask task : todayTaskList){
                content += task.showDetails() +"\n";

            }
            Email mail = new Email(receiver.getEmail(), subject,content);
            reminderService.sendAReminder(mail);
        }
        else{
            System.out.println("No tasks for today! "+ LocalDate.now());
        }
    }
}
