import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Bot {

    private String name;
    private String type;
    private LinkedList<Task> taskQueue = new LinkedList<>();

    public Bot(String name, String type){
        this.name=name;
        this.type=type;
    }

    public void giveTask(String desc, int time){
        taskQueue.add(new Task(desc, time));
    }

    public void completeTask() throws InterruptedException {
        Task task = taskQueue.pop();
        System.out.println("Now completing task "+task.getDescription());
        TimeUnit.MILLISECONDS.sleep(task.getEta());
        System.out.println("Task "+task.getDescription()+" completed in "+task.getEta()+"ms");
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Task> getTaskQueue() {
        return taskQueue;
    }

}
