/*
    Online IDE: https://www.jdoodle.com/online-java-compiler

    Complete the given code fragment with using Java version 8+ that processes a list of Order objects to perform the
    following operations using Java Streams:

    - Group the orders by customerId.
    - For each group, find the average order amount.
    - Filter out groups where the average order amount is less than $5,000.
    - Sort the remaining groups by customerId in ascending order.
    - Collect the results into a TreeMap where the key is customerId and the value is the average order amount.
    - Print the customerId and average order amount for each entry in the final map.
*/
package lambda;
import java.util.*;
import java.util.stream.Collectors;

class Order1 {
    String customerId;
    double amount;

    public Order1(String customerId, double amount) {
        this.customerId = customerId;
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }
}

public class OrderProcessor {
    public static void main(String[] args) {

        List<Order1> orders = Arrays.asList(
                new Order1("C001", 4000),
                new Order1("C002", 6000),
                new Order1("C001", 7000),
                new Order1("C003", 3000),
                new Order1("C002", 8000),
                new Order1("C005", 8000),
                new Order1("C004", 10000)
        );

        //Rakesh
        System.out.println(orders.stream().mapToInt(a->(int)a.getAmount()).max());
//        System.out.println(orders.stream().collect(Collectors.toMap(a->a.getCustomerId(), a->a.getAmount())));
        System.out.println(orders.stream().collect(Collectors.groupingBy(a->a.getCustomerId(),Collectors.averagingDouble(a->a.getAmount()))));
        System.out.println(orders.stream().collect(Collectors.groupingBy(a->a.getCustomerId(), Collectors.summingDouble(a-> a.getAmount()))));
        //rakesh

        //- Group the orders by customerId.
        //- For each group, find the average order amount.
        Map<String, Double> mapAvgOrder = orders.stream().collect(Collectors.groupingBy(Order1::getCustomerId, Collectors.averagingDouble(Order1::getAmount)));
        System.out.println(mapAvgOrder);
//        - Filter out groups where the average order amount is less than $5,000.
//                - Sort the remaining groups by customerId in ascending order.

        TreeMap<String, Double> mapOrderLess = orders.stream().collect(Collectors.groupingBy(Order1::getCustomerId, Collectors.averagingDouble(Order1::getAmount)))
                .entrySet().stream().filter(order->order.getValue()>5000).sorted(Map.Entry.comparingByKey()).
                collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (a,b)->a, TreeMap::new));

        System.out.println(mapOrderLess);

//        - Collect the results into a TreeMap where the key is customerId and the value is the average order amount.
//        - Print the customerId and average order amount for each entry in the final map.
    }
}