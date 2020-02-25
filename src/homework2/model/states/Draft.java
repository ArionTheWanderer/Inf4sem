package homework2.model.states;

import homework2.model.Args;
import homework2.model.State;
import homework2.model.Task;

public class Draft extends State {
    public Draft(Task context) {
        super(context);
    }

    @Override
    public void up(Args args) {
        getContext().changeState(new Open(getContext()));
    }

    @Override
    public void down(Args args) { }
}
