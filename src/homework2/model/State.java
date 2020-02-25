package homework2.model;

public abstract class State {
    private Task context;

    public State(Task context) {
        this.context = context;
    }

    public Task getContext() {
        return context;
    }

    public abstract void up(Args args);

    public abstract void down(Args args);
}
