import java.util.*;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("Entrez la commande à executer");
        Scanner scanner = new Scanner(System.in);

        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new Fibo());
        commands.add(new Freq());
        commands.add(new Quit());

        String command = scanner.nextLine();

        int i = 0;

        while (!command.equals("quit")) {

            for (i = 0; i < commands.size(); i++){
                if (commands.get(i).name().equals(command))
                {
                    if (commands.get(i).run(scanner)) {
                        return;
                    }
                    break;
                }
            }

            if (i == commands.size()) {
                System.out.println("Unknown command");
            }
            else
            {
                System.out.println("Entrez la commande à executer");
            }

            command = scanner.nextLine();
        }
    }
}
