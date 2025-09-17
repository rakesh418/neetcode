package lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Validator{
    public static boolean isNotEmpty(String s ){
        return s!=null && !s.isEmpty();
    }
}

public class MethodReference {
    public static void main(String[] args) {
        Predicate<String> p = Validator::isNotEmpty;
        //Static method reference
        System.out.println(p.test("rakesh"));
        System.out.println(p.test(""));

        //Instance Method Reference
        Predicate<String> p1 = ((Predicate<String>) String::isEmpty).negate();
        System.out.println(p1.test("rakesh"));

        String prefix  = "rakesh";
        Consumer<String> c = s-> System.out.println(s+":"+prefix);
        c.accept("sri ");

        List<String> names = Arrays.asList("John", "Alice", "Bob");
//        names.sort((a,b)->a.compareTo(b));
//        Collections.sort(names,(a,b)->a.compareTo(b));
        System.out.println(names);

    }
}
