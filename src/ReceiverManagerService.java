import java.util.ArrayList;
// highlevel class that accept receiver manager obj
public class ReceiverManagerService {
    IReceiverManager receiverManager;
    public ReceiverManagerService(IReceiverManager receiverManager) {
        this.receiverManager = receiverManager;
    }

    public IReceiver createReceiver(String input){
        return receiverManager.createReceiver(input);
    };
    ArrayList<IReceiver> getReceivers(){
        return receiverManager.getReceivers();
    };
}
