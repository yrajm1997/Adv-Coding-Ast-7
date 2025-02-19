package com.mystore.app.service;

import com.mystore.app.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    //private List<Product> products = new ArrayList<>();
    private Integer currentId = 1;

    private List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(currentId++, "Smartphone", "Electronics", 799.99, 50),
                    new Product(currentId++, "Laptop", "Electronics", 1299.99, 30),
                    new Product(currentId++, "Wireless Headphones", "Electronics", 199.99, 100),
                    new Product(currentId++, "T-shirt", "Clothing", 19.99, 200),
                    new Product(currentId++, "Jeans", "Clothing", 49.99, 150),
                    new Product(currentId++, "Leather Jacket", "Clothing", 159.99, 75),
                    new Product(currentId++, "Running Shoes", "Footwear", 89.99, 120),
                    new Product(currentId++, "Sneakers", "Footwear", 59.99, 200),
                    new Product(currentId++, "Office Chair", "Furniture", 199.99, 40),
                    new Product(currentId++, "Desk", "Furniture", 249.99, 60),
                    new Product(currentId++, "Blender", "Appliances", 89.99, 80),
                    new Product(currentId++, "Microwave Oven", "Appliances", 129.99, 50),
                    new Product(currentId++, "Coffee Maker", "Appliances", 49.99, 90),
                    new Product(currentId++, "Smart Watch", "Electronics", 199.99, 150),
                    new Product(currentId++, "Bluetooth Speaker", "Electronics", 49.99, 250)
            )
    );

    public Product addProduct(Product product) {
        product.setId(currentId++);
        products.add(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(Integer id) {
        return findProductById(id);
    }

    public Product updateProduct(Integer id, Product product) {
        Product p = findProductById(id);
        if (p == null) return null;
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        return p;
    }

    public String deleteProduct(Integer id) {
        Product p = findProductById(id);
        if (p == null) return "Product Not Found";
        products.remove(p);
        return "Product Deleted Successfully";
    }

    private Product findProductById(Integer id) {
        for (Product p: products) {
            if (p.getId().intValue() == id.intValue()) {
                return p;
            }
        }
        return null;
    }

    public List<Product> searchByProductName(String name) {
        List<Product> productsFound = new ArrayList<>();
        for (Product p: products) {
            if (p.getName().contains(name)) {
                productsFound.add(p);
            }
        }
        return productsFound;
    }
}
