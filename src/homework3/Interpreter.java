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
            System.out.println(result + " at " + caretaker.getPosition() + " position");;
        }
        if (command.startsWith("link ")) {
            String link = wordsOfCommand[1];
            String result = caretaker.link(link);
            System.out.println(result + " at " + caretaker.getPosition() + " position");
        }
        if (command.startsWith("back")) {
            String result = caretaker.back();
            System.out.println(result + " at " + caretaker.getPosition() + " position");
        }
        if (command.startsWith("forward")) {
            String result = caretaker.forward();
            System.out.println(result + " at " + caretaker.getPosition() + " position");
        }
        if (command.startsWith("gotoposition ")) {
            int position = Integer.parseInt(wordsOfCommand[1]);
            int result = caretaker.goToPosition(position);
            System.out.println(caretaker.getPage() + " at " + result + " position");
        }
        if (command.startsWith("gotoadv")) {
            String result = caretaker.goToAdv();
            System.out.println(result + " at " + caretaker.getPosition() + " position");
        }
    }
}
