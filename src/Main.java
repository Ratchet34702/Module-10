import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> nameList = List.of("Vold", "Mosha", "Arutr", "Keril", "Viktoria", "Okabe", "Igor");
        String[] numberArray = {"1, 2, 0", "4, 5"};
        System.out.println(task1(nameList));
        System.out.println(task2(nameList));
        System.out.println(task3(numberArray));

        long a = 25214903917L;
        long c = 11;
        long m = 1L << 48;
        System.out.println(task4(2003, a, c, m).limit(7).collect(Collectors.toList()));

        List<Integer> firstList = List.of(0, 2, 4, 6, 8);
        List<Integer> secondList = List.of(1, 3, 5, 7, 9);
        System.out.println(zip(firstList.stream(), secondList.stream()).collect(Collectors.toList()));
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

    static Stream<Long> task4(long seed, long a, long c, long m) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> resultList = new ArrayList<>();
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            resultList.add(firstIterator.next());
            resultList.add(secondIterator.next());
        }
        return resultList.stream();
    }

}


