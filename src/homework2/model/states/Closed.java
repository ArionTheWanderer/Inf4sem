package homework2.model.states;

import homework2.model.Args;
import homework2.model.State;
import homework2.model.Task;

public class Closed extends State {
    public Closed(Task context) {
        super(context);
    }

    @Override
    public void up(Args args) { }

    @Override
    public void down(Args args) { }
}
