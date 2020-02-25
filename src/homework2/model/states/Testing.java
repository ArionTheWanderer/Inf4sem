package homework2.model.states;

import homework2.model.Args;
import homework2.model.State;
import homework2.model.Task;

public class Testing extends State {
    public Testing(Task context) {
        super(context);
    }

    @Override
    public void up(Args args) {
        getContext().setDeveloperId(0);
        getContext().setTesterId(0);
        getContext().changeState(new Closed(getContext()));
    }

    @Override
    public void down(Args args) {
        if (!args.getErrorText().equals("")) {
            String errorText = args.getErrorText();
            getContext().setErrorText(errorText);
            getContext().changeState(new Assigned(getContext()));
        } else {
            System.out.println("Wrong request!");
        }
    }
}
