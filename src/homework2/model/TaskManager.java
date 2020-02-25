package homework2.model;

import homework2.model.states.Open;
import homework2.model.states.Resolved;
import homework2.model.states.Testing;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static TaskManager taskManager;
    private List<ITask> tasks = new ArrayList<>();

    static TaskManager getInstance() {
        return taskManager == null ? taskManager = new TaskManager() : taskManager;
    }

    int command(String command) {
        String[] wordsOfCommand = command.split("  ");
        if (command.startsWith("new  task  ")) {
            if (wordsOfCommand.length == 3) {
                String taskText = wordsOfCommand[2];
                Task newTask = new Task(taskText);
                tasks.add(newTask);
                return tasks.size() - 1;
            } else {
                System.out.println("No task text!");
                return -1;
            }
        }
        if (command.startsWith("up  ")) {
            int index = Integer.parseInt(wordsOfCommand[1]);
            ITask currentTask = tasks.get(index);
            if (currentTask.getState() instanceof Open) {
                int devId = Integer.parseInt(wordsOfCommand[2]);
                Args args = Args.newBuilder().setDeveloperId(devId).build();
                currentTask.up(args);
                return 0;
            } else if (currentTask.getState() instanceof Resolved) {
                int testerId = Integer.parseInt(wordsOfCommand[2]);
                Args args = Args.newBuilder().setTesterId(testerId).build();
                currentTask.up(args);
                return 0;
            } else {
                Args args = Args.newBuilder().build();  // пустышка
                currentTask.up(args);
                return 0;
            }
        }
        if (command.startsWith("down  ")) {
            int index = Integer.parseInt(wordsOfCommand[1]);
            ITask currentTask = tasks.get(index);
            if (currentTask.getState() instanceof Testing) {
                String errorText = wordsOfCommand[2];
                Args args = Args.newBuilder().setErrorText(errorText).build();
                currentTask.down(args);
                return 0;
            } else {
                Args args = Args.newBuilder().build();
                currentTask.down(args);
                return 0;
            }
        }
        if (command.startsWith("copy  ")) {
            int index = Integer.parseInt(wordsOfCommand[1]);
            ITask currentTask = tasks.get(index);
            ITask copiedTask = currentTask.copy();
            tasks.add(copiedTask);
            return tasks.size() - 1;
        }
        System.out.println("Wrong command!");
        return -1;
    }
}
