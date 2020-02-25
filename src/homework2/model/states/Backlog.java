package homework2.model.states;

import homework2.model.Args;
import homework2.model.State;
import homework2.model.Task;

public class Backlog extends State {
    public Backlog(Task context) {
        super(context);
    }

    @Override
    public void up(Args args) {
        getContext().changeState(new Open(getContext()));
    }

    @Override
    public void down(Args args) { }
}
