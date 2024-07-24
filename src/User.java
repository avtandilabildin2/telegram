import java.util.ArrayList;
import java.util.List;

public class User {
    private long id=0;
    private String login;
    private String password;
    private String phone;
    private int countMessage;
    private Message message;
    private List<String> messages;



    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getCountMessage() {
        return countMessage++;
    }

    public void setCountMessage(int countMessage) {
        this.countMessage = countMessage;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
    public User() {
        this.id++;
        this.messages = new ArrayList<>();
        message=new Message();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
