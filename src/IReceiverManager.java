
import java.util.ArrayList;

public interface IReceiverManager {
    IReceiver createReceiver(String input);
    ArrayList<IReceiver> getReceivers();
}
