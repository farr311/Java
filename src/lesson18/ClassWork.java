package lesson18;

import java.util.*;

public class ClassWork {

    public static void main(String[] args) {
        scannerTest();
    }

    static void scannerTest() {
        Scanner scanner = new Scanner(System.in);

        /*List<Integer> list = new ArrayList<>();

        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            if (i == -1) {
                break;
            }

            list.add(i);
        }

        System.out.println(list);*/

        StringBuilder s = new StringBuilder();

        while (scanner.hasNextLine()) {
            String l = scanner.nextLine();

            if (l.equalsIgnoreCase("-1")) {
                break;
            }

            if (!s.isEmpty()) {
                s.append(" ");
            }
            s.append(l);
        }

        System.out.println(s);
    }

    static void printTest() {
        System.out.println("Hello world");
        System.err.println("Hello world");

        System.out.println("Test1");
        System.out.println("Test2");

        System.out.println("+".repeat(50));
        System.out.print("Test1 \n");
        System.out.print("Test2");

        System.out.printf("one%ntwo%nthree%n");
        System.out.printf("%b%n", null);
        System.out.printf("%b%n", false);
        System.out.printf("%b%n", true);
        System.out.printf("%b%n", 0);
        System.out.printf("%b%n", 1);
        System.out.printf("%b%n", new int[0]);

        System.out.printf("%.8s%n", "Hello World");

        System.out.printf("%C%n", 'a');

        System.out.printf("x = %.3f%n", Math.PI);

        Date d = new Date();

        System.out.printf("Hour: %tH, Minutes: %tM, Seconds: %tS%n", d, d, d);
    }

    static void flatMap() {
        List<String> list = List.of("a", "b", "c");

        List<String> result = list.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(result);

        List<List<String>> matrix = Arrays.asList(
                List.of("a"),
                List.of("b"),
                List.of("c")
        );

        System.out.println(matrix);

        List<String> matrixResult = matrix.stream()
                .flatMap(Collection::stream)
                .map(String::toUpperCase)
                .toList();

        System.out.println(matrixResult);
    }
}
