package homework3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Interpreter interpreter = Interpreter.getInstance();
        Browser browser = new Browser();
        Caretaker caretaker = new Caretaker(browser);
        String command = scanner.nextLine();
        do {
            interpreter.command(command, caretaker);
            command = scanner.nextLine();
        } while (!command.startsWith("stop"));
        System.out.println("Exit");
    }
}
