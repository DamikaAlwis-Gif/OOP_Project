public class ReminderService {

    private IReminderOperations reminderOperations;

    public ReminderService(IReminderOperations reminderOperations) {
        this.reminderOperations = reminderOperations;
    }

    public void sendAReminder(Reminder reminder){
        reminderOperations.sendAReminder(reminder);
    }
}
