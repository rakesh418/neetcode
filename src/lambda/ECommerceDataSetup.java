package lambda;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String productId;
    private String category;
    private double price;

    public Product(String productId, String category, double price) {
        this.productId = productId;
        this.category = category;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
}

class Order {
    private String orderId;
    private String userId;
    private List<Product> products;
    private LocalDate orderDate;

    public Order(String orderId, String userId, List<Product> products, LocalDate orderDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.products = products;
        this.orderDate = orderDate;
    }

    public String getOrderId() { return orderId; }
    public String getUserId() { return userId; }
    public List<Product> getProducts() { return products; }
    public LocalDate getOrderDate() { return orderDate; }
}

class User {
    private String userId;
    private String name;
    private int age;
    private String country;

    public User(String userId, String name, int age, String country) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCountry() { return country; }
}

public class ECommerceDataSetup {
    public static void main(String[] args) {
        // --- Sample Users ---
        List<User> users = Arrays.asList(
                new User("U001", "Alice", 22, "USA"),
                new User("U002", "Bob", 30, "USA"),
                new User("U003", "Charlie", 40, "UK"),
                new User("U004", "Diana", 28, "India"),
                new User("U005", "Eve", 35, "Germany")
        );

        // --- Sample Products ---
        List<Product> products = Arrays.asList(
                new Product("P001", "Electronics", 1200),
                new Product("P002", "Books", 50),
                new Product("P003", "Clothing", 200),
                new Product("P004", "Electronics", 800),
                new Product("P005", "Books", 30),
                new Product("P006", "Clothing", 150),
                new Product("P007", "Electronics", 1500),
                new Product("P008", "Books", 70)
        );

        // --- Sample Orders ---
        List<Order> orders = Arrays.asList(
                new Order("O001", "U001", Arrays.asList(products.get(0), products.get(1)), LocalDate.now().minusDays(10)),
                new Order("O002", "U002", Arrays.asList(products.get(2), products.get(3)), LocalDate.now().minusDays(20)),
                new Order("O003", "U001", Arrays.asList(products.get(4), products.get(5)), LocalDate.now().minusDays(15)),
                new Order("O004", "U003", Arrays.asList(products.get(6)), LocalDate.now().minusDays(30)),
                new Order("O005", "U004", Arrays.asList(products.get(1), products.get(5)), LocalDate.now().minusDays(5)),
                new Order("O006", "U002", Arrays.asList(products.get(0), products.get(7)), LocalDate.now().minusDays(2)),
                new Order("O007", "U005", Arrays.asList(products.get(3), products.get(2)), LocalDate.now().minusDays(40)),
                new Order("O008", "U001", Arrays.asList(products.get(6)), LocalDate.now().minusDays(60)),
                new Order("O009", "U004", Arrays.asList(products.get(0), products.get(3)), LocalDate.now().minusDays(1))
        );

        // --- Print sample data ---
        System.out.println("Users:");
        users.forEach(u -> System.out.println(u.getUserId() + " | " + u.getName() + " | " + u.getAge() + " | " + u.getCountry()));
        System.out.println("\nOrders:");
        orders.forEach(o -> System.out.println(o.getOrderId() + " | " + o.getUserId() + " | " + o.getProducts().stream()
                .map(Product::getProductId)
                .collect(Collectors.joining(", ")) + " | " + o.getOrderDate()));

        orders.forEach(order-> System.out.println(order.getOrderId() + "|" + order.getUserId() + "|" + order.getProducts().stream().map(p->p.getProductId()).collect(Collectors.joining(","))));
    }
}
