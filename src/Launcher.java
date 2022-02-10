import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("welcome");

        Scanner scanner = new Scanner(System.in);
        Launcher launcher = new Launcher();

        String command = scanner.nextLine();

        while (!command.equals("quit")) {

            if ("fibo".equals(command)) {
                System.out.println("entrez un nombre n pour calculer la suite de fibo à cet index");
                int n = Integer.parseInt(scanner.nextLine());
                System.out.println( launcher.fibo(n) );
                break;
            }
            else if ("freq".equals(command)) {
                System.out.println("entrez le chemin du fichier");
                String input = scanner.nextLine();
                String file;

                try {
                    Path path = Paths.get(input);
                    file = java.nio.file.Files.readString(path);
                } catch (Exception e) {
                    System.out.println("Unreadable file: " + e);
                    break;
                }

                launcher.freq(file);

                break;
            }

            System.out.println("Unknown command");
            command = scanner.nextLine();
        }
    }

    public void freq(String file) {
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
    }

    public int fibo(int n) {
        int i = 1;
        int fn1 = 1;
        int fn2 = 0;
        int fn;

        if (n == 0) return fn1;
        if (n == 1) return fn2;

        while( i != n) {
            int tmp = fn1;
            fn1 += fn2;
            fn2 = tmp;
            i++;
        }

        return fn1;
    }
}
