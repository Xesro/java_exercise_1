import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("welcome");
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        if (!command.equals("quit")) {
            System.out.println("Unknown command");
        }
    }
}
