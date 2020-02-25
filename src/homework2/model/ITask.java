package homework2.model;

public interface ITask {
    void up(Args args);
    void down(Args args);
    void changeState(State state);
    String getText();
    int getDeveloperId();
    int getTesterId();
    String getErrorText();
    State getState();
    void setDeveloperId(int developerId);
    void setTesterId(int testerId);
    void setErrorText(String errorText);
    ITask copy();
}
