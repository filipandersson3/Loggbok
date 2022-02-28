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
        return author + " " + updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntry logEntry = (LogEntry) o;

        if (createdAt != null ? !createdAt.equals(logEntry.createdAt) : logEntry.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(logEntry.updatedAt) : logEntry.updatedAt != null) return false;
        if (message != null ? !message.equals(logEntry.message) : logEntry.message != null) return false;
        return author != null ? author.equals(logEntry.author) : logEntry.author == null;
    }

    @Override
    public int hashCode() {
        int result = createdAt != null ? createdAt.hashCode() : 0;
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    public void update(String newAuthor, String newMessage) {
        author = newAuthor;
        message = newMessage;
        updatedAt = new Date();
    }
}