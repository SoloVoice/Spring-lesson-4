package ru.geekbrains.boot.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.boot.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        products.add(new Product(1, "Шапка", 10000));
        products.add(new Product(2, "Свитер", 12000));
        products.add(new Product(3, "Куртка", 14000));
        products.add(new Product(4, "Перчатки", 16000));
        products.add(new Product(5, "Носки", 18000));
        products.add(new Product(6, "Рюкзак", 20000));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
    public void deleteById(int id) {
        products.removeIf(b -> b.getId() == (id));
    }

}
