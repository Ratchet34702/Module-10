import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> nameList = List.of("Vold", "Mosha", "Arutr", "Keril", "Viktoria", "Okabe", "Igor");
        String[] numberArray = {"1, 2, 0", "4, 5"};
        System.out.println(task1(nameList));
        System.out.println(task2(nameList));
        System.out.println(task3(numberArray));

    }

    static String task1(List<String> nameList) {
        return nameList.stream()
                .filter(s -> nameList.indexOf(s) % 2 == 0)
                .map(s -> (new StringBuilder()
                        .append(nameList.indexOf(s) + 1)
                        .append(". ")
                        .append(s)
                        .toString()))
                .collect(Collectors.joining(", "));
    }

    static List<String> task2(List<String> stringList) {
        return stringList.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    static List<Integer> task3(String[] stringArray) {
        return Arrays.stream(stringArray)
                .flatMap(s -> Stream.of(s.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }
}


