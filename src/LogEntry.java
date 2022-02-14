import java.io.Serializable;
import java.util.Date;

public class LogEntry implements Serializable{
    private Date createdAt;
    private Date updatedAt;
    private String message;
    private String author;

    public LogEntry(String author, String message) {
        this.author = author;
        this.message = message;
        createdAt = new Date();
        updatedAt = new Date();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "LogEntry{"+ "author=" + author + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + ", message='" + message + '\'' + '}';
    }

    public void update(String newAuthor, String newMessage) {
        author = newAuthor;
        message = newMessage;
        updatedAt = new Date();
    }
}