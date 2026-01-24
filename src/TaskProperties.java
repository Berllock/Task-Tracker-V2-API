import java.time.LocalDate;

public class TaskProperties {

    private String id;
    private String description;
    private TaskStatus status;
    private String createdAt;
    private String updatedAt;

    public TaskProperties() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = TaskStatus.valueOf(status);
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (Status: %s, Updated: %s)",
                id.substring(0, Math.min(8, id.length())),
                description,
                status,
                updatedAt);
    }
}
