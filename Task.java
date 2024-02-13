import java.util.*;

public class Task implements TaskInterface, Comparable<Task> {

    private int priority;
    private TaskType taskType;
    private int waitingTime;
    private int hourCreated;
    private String description;

    // Constructor
    public Task(int priority, TaskType taskType, int hourCreated, String description) {
        this.priority = priority;
        this.taskType = taskType;
        this.hourCreated = hourCreated;
        this.description = description;
    }

    // Implementing TaskInterface methods

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public TaskType getTaskType() {
        return taskType;
    }

    @Override
    public void incrementWaitingTime() {
        waitingTime++;
    }

    @Override
    public void resetWaitingTime() {
        waitingTime = 0;
    }

    @Override
    public int getWaitingTime() {
        return waitingTime;
    }
}