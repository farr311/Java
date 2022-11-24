package lesson17.streampractice;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Product {
    private Long id;
    private String name;
    private String category;
    private Double price;
    private Set<Order> orders;


    public Product(long id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.orders = new HashSet<>();
    }

    public Product(long id, String name, String category, double price, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.orders = orders;
    }

    public Product() {
        this.orders = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOrder(Order o) {
        this.orders.add(o);
    }

    public Set<Order> getOrders() {
        return this.orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id)
                && Objects.equals(name, product.name)
                && Objects.equals(category, product.category)
                && Objects.equals(price, product.price)
                && Objects.equals(orders, product.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price, orders);
    }
}