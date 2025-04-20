public interface Task {

    int getId();
    String getDescription();
    void setDescription(String description);

    Priority getPriority();
    void setPriority(Priority priority);

    Status getStatus();
    void setStatus(Status status);

}
