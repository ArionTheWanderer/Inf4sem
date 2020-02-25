package homework2.model.states;

import homework2.model.Args;
import homework2.model.State;
import homework2.model.Task;

public class Assigned extends State {
    public Assigned(Task context) {
        super(context);
    }

    @Override
    public void up(Args args) {
        getContext().changeState(new InProgress(getContext()));
    }

    @Override
    public void down(Args args) {
        getContext().setDeveloperId(0);
        getContext().changeState(new Open(getContext()));
    }
}
