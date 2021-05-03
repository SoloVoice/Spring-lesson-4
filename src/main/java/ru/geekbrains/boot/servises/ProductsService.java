package ru.geekbrains.boot.servises;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.boot.model.Product;
import ru.geekbrains.boot.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductRepository productsRepository;

    public List<Product> getAllProducts() {
        return productsRepository.getProducts();
    }

    public Product getProductById(int id) {
        for (Product p: productsRepository.getAllProducts()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    public void addProduct(int id, String name, int cost) {
        productsRepository.addProduct(new Product(id, name, cost));
    }
    public void deleteProduct(int id) {
        productsRepository.deleteById(id);
    }

}
