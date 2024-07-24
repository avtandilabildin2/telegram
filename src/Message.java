import java.time.LocalDateTime;

public class Message {
    private User recipient;
    private User author;
    private String message;
    private LocalDateTime dateCreate;
    private boolean readMessage;

    @Override
    public String toString() {
        return "Message{" +
                "recipient=" + recipient +
                ", author=" + author +
                ", message='" + message + '\'' +
                ", dateCreate=" + dateCreate +
                ", readMessage=" + readMessage +
                '}';
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isReadMessage() {
        return readMessage;
    }

    public void setReadMessage(boolean readMessage) {
        this.readMessage = readMessage;
    }
}
