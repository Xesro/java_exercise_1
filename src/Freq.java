import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Freq implements Command {


    @Override
    public String name() {
        return "freq";
    }

    @Override
    public Boolean run(Scanner scanner) {

        System.out.println("Entrez le chemin du fichier");
        String input = scanner.nextLine();
        String file;

        try {
            Path path = Paths.get(input);
            file = java.nio.file.Files.readString(path);
        } catch (Exception e) {
            System.out.println("Unreadable file: " + e);
            return false;
        }

        file = file.replaceAll("[,;:.!?]", " ");
        file = file.toLowerCase(Locale.ROOT);
        String[] words = file.split(" ");

        Map<String, Long> counts = Arrays
                .stream(words)
                .filter(e -> !e.isBlank())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        List<Map.Entry<String, Long>> res = new ArrayList<>(counts.entrySet());

        res.sort(Map.Entry.<String, Long>comparingByValue().reversed());

        System.out.println(res.get(0).getKey() + " " + res.get(1).getKey() + " " + res.get(2).getKey());

        return true;
    }
}
