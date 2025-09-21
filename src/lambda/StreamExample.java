package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product1{
    int id;
    String name;
    float price;
    public Product1(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class StreamExample {
    public static void main(String[] args) {
        List<Product1> productsList = new ArrayList<>();
        //Adding Products
        productsList.add(new Product1(1,"HP Laptop",25000f));
        productsList.add(new Product1(2,"Dell Laptop",30000f));
        productsList.add(new Product1(3,"Lenevo Laptop",28000f));
        productsList.add(new Product1(4,"Sony Laptop",28000f));
        productsList.add(new Product1(5,"Apple Laptop",90000f));

        Product1 product = productsList.stream().max((p1,p2)->p1.price>p2.price?1:-1).get();
        Product1 product1 = productsList.stream().min((p1,p2)->p1.price>p2.price?1:-1).get();
        System.out.println("max: "+product.price);
        System.out.println("min: "+product1.price);

        Map<String, Integer> productPriceMap = productsList.stream().collect(Collectors.toMap(p->p.name,p->(int)p.price));
        System.out.println(productPriceMap);
    }
}
