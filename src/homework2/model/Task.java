package homework2.model;

import homework2.model.states.*;

public class Task implements ITask {

    public String getText() {
        return text;
    }

    public int getDeveloperId() {
        return developerId;
    }

    public int getTesterId() {
        return testerId;
    }

    public String getErrorText() {
        return errorText;
    }

    public State getState() {
        return state;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public void setTesterId(int testerId) {
        this.testerId = testerId;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    private String text;
    private int developerId;
    private int testerId;
    private String errorText;

    @Override
    public String toString() {
        return "Task{" +
                "text='" + text + '\'' +
                ", developerId=" + developerId +
                ", testerId=" + testerId +
                ", errorText='" + errorText + '\'' +
                ", state=" + state.getClass().getName() +
                '}';
    }

    public void setState(State state) {
        this.state = state;
    }

    private State state;

    Task(String text) {
        this.text = text;
        state = new Draft(this);
    }

    private Task(Task prototype) {
        this(prototype.text);
        developerId = prototype.developerId;
        testerId = prototype.testerId;
        errorText = prototype.errorText;
        if (prototype.getState() instanceof Draft) {
            state = new Draft(this);
        } else if (prototype.getState() instanceof Open) {
            state = new Open(this);
        } else if (prototype.getState() instanceof Backlog) {
            state = new Backlog(this);
        } else if (prototype.getState() instanceof Assigned) {
            state = new Assigned(this);
        } else if (prototype.getState() instanceof InProgress) {
            state = new InProgress(this);
        } else if (prototype.getState() instanceof Resolved) {
            state = new Resolved(this);
        } else if (prototype.getState() instanceof Testing) {
            state = new Testing(this);
        } else if (prototype.getState() instanceof Closed) {
            state = new Closed(this);
        }
    }

    public ITask copy() {
        return new Task(this);
    }

    public void up(Args args) {
        state.up(args);
    }

    public void down(Args args) {
        state.down(args);
    }

    public void changeState(State state) {
        this.state = state;
    }
}
