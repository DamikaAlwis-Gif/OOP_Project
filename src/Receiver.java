public class Receiver implements  IReceiver {
    private String name;
    private String email;

    public Receiver(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }
}
