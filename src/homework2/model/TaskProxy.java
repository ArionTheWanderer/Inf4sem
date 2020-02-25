package homework2.model;

import homework2.service.Logger;
import homework2.model.states.Draft;

public class TaskProxy implements ITask {

    private Task task;

    TaskProxy(String taskText) {
        task = new Task(taskText);
        task.setState(new Draft(task));
    }

    @Override
    public void up(Args args) {
        Logger.getInstance().log(task.toString() + " up(" + args.toString() + ")");
        task.getState().up(args);
        Logger.getInstance().log("and became to " + task.toString());
    }

    @Override
    public void down(Args args) {
        Logger.getInstance().log(task.toString() + " down(" + args.toString() + ")");
        task.getState().down(args);
        Logger.getInstance().log("and became to " + task.toString());
    }

    @Override
    public void changeState(State state) {
        task.setState(state);
    }

    @Override
    public String getText() {
        return task.getText();
    }

    @Override
    public int getDeveloperId() {
        return task.getDeveloperId();
    }

    @Override
    public int getTesterId() {
        return task.getTesterId();
    }

    @Override
    public String getErrorText() {
        return task.getErrorText();
    }

    @Override
    public State getState() {
        return task.getState();
    }

    @Override
    public void setDeveloperId(int developerId) {
        task.setDeveloperId(developerId);
    }

    @Override
    public void setTesterId(int testerId) {
        task.setTesterId(testerId);
    }

    @Override
    public void setErrorText(String errorText) {
        task.setErrorText(errorText);
    }

    @Override
    public ITask copy() {
        return task.copy();
    }
}
