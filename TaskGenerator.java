import java.util.Random;

public class TaskGenerator implements TaskGeneratorInterface {

    private int currentEnergyStorage = DEFAULT_ENERGY;
    private final double taskGenerationProbability;
    private final Random random;

    public TaskGenerator(double taskGenerationProbability) {
        this.taskGenerationProbability = taskGenerationProbability;
        this.random = new Random();
    }

    public TaskGenerator(double taskGenerationProbability, long randomSeed) {
        this.taskGenerationProbability = taskGenerationProbability;
        this.random = new Random(randomSeed);
    }

    public TaskGenerator(double taskGenerationProbability, Random random) {
        this.taskGenerationProbability = taskGenerationProbability;
        this.random = random;
    }

    @Override
    public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
        return new Task(0, taskType, hourCreated, taskDescription);
    }

    @Override
    public void decrementEnergyStorage(TaskInterface.TaskType taskType) {
        int energyCost = taskType.getEnergyPerHour();
        currentEnergyStorage -= energyCost;
    }

    @Override
    public void resetCurrentEnergyStorage() {
        currentEnergyStorage = DEFAULT_ENERGY;
    }

    @Override
    public int getCurrentEnergyStorage() {
        return currentEnergyStorage;
    }

    @Override
    public void setCurrentEnergyStorage(int newEnergyNum) {
        currentEnergyStorage = newEnergyNum;
    }

    @Override
    public boolean generateTask() {
        if (taskGenerationProbability > random.nextDouble()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getUnlucky(Task task, double unluckyProbability) {
        if (unluckyProbability <= task.getTaskType().getPassingOutProbability()) {
            if (unluckyProbability <= task.getTaskType().getDyingProbability() && task.getTaskType() == TaskInterface.TaskType.MINING) {
                currentEnergyStorage -= currentEnergyStorage * 0.75;
                task.setPriority(0);
                return 2;
            } else {
                currentEnergyStorage -= currentEnergyStorage * 0.5;
                return 1;
            }
        } else {
            return 0;
        }
    }

    /**
     * Create a String containing the Task's information.
     *
     * @param task - the Task
     * @param taskType - the Task's type
     */
    @Override
    public String toString(Task task, Task.TaskType taskType) {
        if(taskType == Task.TaskType.MINING) {
            return "     Mining " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FISHING) {
            return "     Fishing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FARM_MAINTENANCE) {
            return "     Farm Maintenance " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FORAGING) {
            return "     Foraging " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FEEDING) {
            return "     Feeding " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.SOCIALIZING) {
            return "     Socializing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        else { return "nothing to see here..."; }
    }
}