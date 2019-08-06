import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {
    public static void main(String[] args) {
        /*List<Integer> ls1 = Arrays.asList(1, 2, 3);
        List<Integer> ls2 = Arrays.asList(5, 6, 7);

        List<int[]> collect = ls1.stream()
                .flatMap(i -> ls2.stream().filter(j -> (i+j)%3 == 0).map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
       collect.forEach(e -> System.out.println(e[0]+","+e[1]));*/

        System.out.println(1%1 == 0);
        System.out.println(1%1.0 == 0);
        System.out.println(1.2%1.0 == 0);
    }
}
