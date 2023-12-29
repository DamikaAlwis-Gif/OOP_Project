import java.time.LocalDate;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailOperations implements IReminderOperations {
    private String username = "nuswarwick@gmail.com";
    private String password = "xpbpjfnqjkzlqmzy";

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void sendAReminder(Reminder reminder) {
        //host
        String host="smtp.gmail.com";
        //properties
        Properties prop=System.getProperties();

        //setting the server
        prop.put("mail.smtp.host",host);
        prop.put("mail.smtp.port","465");
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.auth","true");


        //passing username and password to session object
        Session session=Session.getInstance(prop,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        session.setDebug(true);
        try {
            MimeMessage message= new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(reminder.getTo()));
            message.setSubject(reminder.getSubject());
            message.setText(reminder.getContent());

            Transport.send(message);
            System.out.println("Email sent successfully! "+ LocalDate.now());



        }catch(MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
