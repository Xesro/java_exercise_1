import java.util.*;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {

        String file = "toto : tu ; tu titi toto toto ty ty ty ty ";
        file = file.replaceAll("[,;:.!?]", " ");
        file = file.toLowerCase(Locale.ROOT);
        String[] words = file.split(" ");
        Map<String, Long> counts = Arrays.stream(words).filter(e -> !e.isBlank()).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Object[] res = counts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()).toArray();
    }
}
