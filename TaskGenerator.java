import java.util.Random;

public class TaskGenerator implements TaskGeneratorInterface {

    private int currentEnergyStorage;
    private final double unluckyProbability;
    private final Random random;

    public TaskGenerator(double unluckyProbability) {
        this(unluckyProbability, new Random());
    }

    public TaskGenerator(double unluckyProbability, long randomSeed) {
        this(unluckyProbability, new Random(randomSeed));
    }

    public TaskGenerator(double unluckyProbability, Random random) {
        this.currentEnergyStorage = 0;
        this.unluckyProbability = unluckyProbability;
        this.random = random;
    }

    @Override
    public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
        int priority = 0;
        if (generateTask()) {
            priority = random.nextInt(10) + 1;
        }
        return new Task(hourCreated, taskType, taskDescription, priority);
    }

    @Override
    public void decrementEnergyStorage(TaskInterface.TaskType taskType) {
        int energyCost = Task.getEnergyCost(taskType);
        currentEnergyStorage -= energyCost;
        if (currentEnergyStorage < 0) {
            currentEnergyStorage = 0;
        }
    }

    @Override
    public void resetCurrentEnergyStorage() {
        currentEnergyStorage = 0;
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
        return random.nextDouble() < unluckyProbability;
    }

    @Override
    public int getUnlucky(Task task, double unluckyProbability) {
        if (generateTask()) {
            if (random.nextDouble() < unluckyProbability) {
                if (random.nextBoolean()) {
                    task.setPassedOut(true);
                } else {
                    task.setDied(true);
                }
                return 1;
            }
        }
        return 0;
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