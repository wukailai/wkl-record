import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList();
        list2.add(2);
        list2.add(3);
        List<Integer> allTableList = Stream.of(list1, list2).flatMap(Collection::stream).distinct().limit(3).collect(Collectors.toList());
        System.out.println(allTableList);
    }
}