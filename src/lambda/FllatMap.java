package lambda;

import java.util.Arrays;
import java.util.List;

class Person {
    String name;
    List<String> phones;

    Person(String name, List<String> phones) {
        this.name = name;
        this.phones = phones;
    }
}

public class FllatMap {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("rakesh", Arrays.asList("11","22")),
                new Person("rakesh2", Arrays.asList("33","44")));
        List<String> phones = people.stream().flatMap(p->p.phones.stream()).toList();
        System.out.println(phones);
    }
}
