import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
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
        Map<String, Long> counts = Arrays.
                stream(words).
                filter(e -> !e.isBlank()).
                collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Object[] res = counts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).toArray();

        System.out.println(res[res.length - 1] + " " + res[res.length - 2] + " " + res[res.length - 3]);

        return false;
    }
}
