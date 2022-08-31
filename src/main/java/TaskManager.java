public class TaskManager {
    private Task[] tasks = new Task[100];
    private int taskCount = 0;

    public void greet() {
        System.out.println("  ____________________________________________________________");
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println("  ____________________________________________________________");
    }

    public void bye() {
        System.out.println("  ____________________________________________________________");
        System.out.println("\tBye. Hope to see you again soon!");
        System.out.println("  ____________________________________________________________");
    }

    public void addTask(String line, String commandWord) {
        if (commandWord.equals("todo")) {
            tasks[taskCount] = new Todo(line);
        } else if (commandWord.equals("deadline")) {
            int index = line.indexOf("/by ");
            String by = line.substring(index + 4);
            line = line.substring(0, index - 1);
            tasks[taskCount] = new Deadline(line, by);
        } else if (commandWord.equals("event")) {
            int index = line.indexOf("/at ");
            String at = line.substring(index + 4);
            line = line.substring(0, index - 1);
            tasks[taskCount] = new Event(line, at);
        } else {
            tasks[taskCount] = new Task(line);
        }
        System.out.println("  ____________________________________________________________");
        System.out.println("\tAdded:");
        System.out.println("\t  " + tasks[taskCount].getType() + tasks[taskCount].getStatus()
                + tasks[taskCount].getDescription() + tasks[taskCount].getAddedInfo());
        taskCount++;
        System.out.println("\tNow you have " + taskCount + " tasks in the list");
        System.out.println("  ____________________________________________________________");
    }

    public void listTasks() {
        System.out.println("  ____________________________________________________________");
        System.out.println("\tThese are the tasks in your list:");
        for (int i = 0; i < taskCount; i += 1) {
            int index = i + 1;
            System.out.println("\t" + index + "." + tasks[i].getType() + tasks[i].getStatus()
                    + " " + tasks[i].getDescription() + tasks[i].getAddedInfo());
        }
        System.out.println("  ____________________________________________________________");
    }

    public void markTask(String line) {
        int index = Integer.parseInt(line) - 1;
        tasks[index].setCompletion(true);
        System.out.println("  ____________________________________________________________");
        System.out.println("\tWell done! I have marked this task as completed:");
        System.out.println("\t  " + tasks[index].getType() + tasks[index].getStatus() + " "
                + tasks[index].getDescription() + tasks[index].getAddedInfo());
        System.out.println("  ____________________________________________________________");
    }

    public void unmarkTask(String line) {
        int index = Integer.parseInt(line) - 1;
        tasks[index].setCompletion(false);
        System.out.println("  ____________________________________________________________");
        System.out.println("\tNoted. I have marked this task as incomplete:");
        System.out.println("\t  " + tasks[index].getType() + tasks[index].getStatus() + " "
                + tasks[index].getDescription() + tasks[index].getAddedInfo());
        System.out.println("  ____________________________________________________________");
    }
}
