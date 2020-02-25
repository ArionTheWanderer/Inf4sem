package homework2.model.states;

import homework2.model.Args;
import homework2.model.State;
import homework2.model.Task;

public class Open extends State {
    public Open(Task context) {
        super(context);
    }

    @Override
    public void up(Args args) {
        int devId = args.getDeveloperId();
        getContext().setDeveloperId(devId);
        getContext().changeState(new Assigned(getContext()));
    }

    @Override
    public void down(Args args) {
        getContext().changeState(new Backlog(getContext()));
    }
}
