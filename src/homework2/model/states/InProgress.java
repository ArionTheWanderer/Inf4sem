package homework2.model.states;

import homework2.model.Args;
import homework2.model.State;
import homework2.model.Task;

public class InProgress extends State {
    public InProgress(Task context) {
        super(context);
    }

    @Override
    public void up(Args args) {
        getContext().changeState(new Resolved(getContext()));
    }

    @Override
    public void down(Args args) {
        getContext().changeState(new Assigned(getContext()));
    }
}
