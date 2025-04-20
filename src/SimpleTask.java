public class SimpleTask implements Task{
    private static int counter = 0;

    private final int id;
    private String description;
    private Priority priority;
    private Status status;

    public SimpleTask(String description, Priority priority, Status status) {
        this.id = ++counter;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task #" + id + " [" + status + "] " + description + " (" + priority + ")";
    }
}
