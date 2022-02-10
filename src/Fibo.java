import java.util.Scanner;

public class Fibo implements Command{

    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public Boolean run(Scanner scanner) {
        System.out.println("Entrez un nombre n pour calculer la suite de fibo à cet index");
        int n = Integer.parseInt(scanner.nextLine());

        int i = 1;
        int fn1 = 1;
        int fn2 = 0;
        int fn;

        if (n == 0 || n == 1) {
            System.out.println(n);
            return false;
        }

        while( i != n) {
            int tmp = fn1;
            fn1 += fn2;
            fn2 = tmp;
            i++;
        }

        System.out.println(fn1);

        return false;
    }
}
