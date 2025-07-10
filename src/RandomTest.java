import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RandomTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<Integer> number = Arrays.asList(4,3,8);
//        names.sort((a, b) -> a.compareTo(b));
        names.sort((a, b) -> a.compareTo(b));
        number.sort((a,b)->a-b);
        Optional<Integer> n =  number.stream().max((a,b)->a-b);
        String name = "Alice";
        System.out.println(name.substring(0,0)+"*");
    }
}
