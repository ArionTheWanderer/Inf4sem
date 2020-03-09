package homework3;

public class Interpreter {
    private static Interpreter interpreter;

    static Interpreter getInstance() {
        return interpreter == null ? interpreter = new Interpreter() : interpreter;
    }

    private Interpreter() {}

    public void command(String command, Caretaker caretaker) {
        String[] wordsOfCommand = command.split(" ");
        if (command.startsWith("goto ")) {
            String link = wordsOfCommand[1];
            String result = caretaker.go_to(link);
            System.out.println(result);;
        }
        if (command.startsWith("link ")) {
            String link = wordsOfCommand[1];
            String result = caretaker.link(link);
            System.out.println(result);
        }
        if (command.startsWith("back")) {
            String result = caretaker.back();
            System.out.println(result);
        }
        if (command.startsWith("forward")) {
            String result = caretaker.forward();
            System.out.println(result);
        }
    }
}
