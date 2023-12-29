public class User implements IReceiver {
    private String password;
    private String name;
    private String email;

    public User(String name, String email , String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
