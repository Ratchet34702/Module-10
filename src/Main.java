import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = List.of("Vold", "Mosha", "Arutr", "Keril", "Viktoria", "Okabe", "Igor");
        System.out.println(task1(stringList));
        System.out.println(task2(stringList));

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
}


