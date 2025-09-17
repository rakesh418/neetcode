package lambda;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.function.*;

public class FunctionalInt {
    public static void main(String[] args) {
        //Predicate
        Predicate<String> p = s-> s.equals("rakesh");
        System.out.println("predicate: "+ p.test("rakesh"));
        System.out.println("predicate: "+ p.test("name"));
        System.out.println();

        //bi-Predicate
        BiPredicate<String, String> p1 = (s1,s2)->s1.equals(s2);
        System.out.println("bi-predicate: "+ p1.test("r1","r1"));
        System.out.println("bi-predicate: "+ p1.test("r1","r2"));

        //function
        Function<String, Integer> f1 = s->s.length();
        System.out.println("function: "+ f1.apply("rakesh"));

        //Bi-function
        BiFunction<String, String, Integer> f2 = (s1,s2)->s1.length()+s2.length();
        System.out.println("bi-function: "+ f2.apply("rakesh","dutta"));

        //Consumer
        Consumer<String> c = str -> System.out.println(str.length());
        c.accept("mumu");

        //Bi-Consumer
        BiConsumer<String, String> c1 = (str1,str2) -> System.out.println(str1.length()+str2.length());
        c1.accept("test", "again");

        //Supplier
        Supplier<String> s = ()-> String.valueOf(Math.random());
        System.out.println(s.get());

        System.out.println(Integer.compare(3,2));
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        queue.addAll(map.values());
    }
}
