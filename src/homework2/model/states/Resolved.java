package homework2.model.states;

import homework2.model.Args;
import homework2.model.State;
import homework2.model.Task;

public class Resolved extends State {
    public Resolved(Task context) {
        super(context);
    }

    @Override
    public void up(Args args) {
        int testerId = args.getTesterId();
        getContext().setTesterId(testerId);
        getContext().changeState(new Testing(getContext()));
    }

    @Override
    public void down(Args args) {
        getContext().changeState(new InProgress(getContext()));
    }
}
