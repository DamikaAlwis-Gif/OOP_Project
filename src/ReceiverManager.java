import java.util.ArrayList;
// concreate class that implement receiver manager interface
public class ReceiverManager implements IReceiverManager {

    private ArrayList<IReceiver> receivers = new ArrayList<>();

    public ArrayList<IReceiver> getReceivers() {
        return receivers;
    }

    @Override
    public IReceiver createReceiver(String input){
        IReceiver receiver = null;
        try{
            String[] arr = input.split(",");
            if (arr.length >=2){
                receiver = new Receiver(arr[0],arr[1]);
                receivers.add(receiver);
                return receiver;
            }

//        FileManager.writeToFile("receivers",input);

        }
        catch (Exception e){
            System.out.println(e);

        }
        return receiver;

    }
}


