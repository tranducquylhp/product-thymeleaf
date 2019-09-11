package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private  static  Map<Integer, Product> customers;

    static {

        customers = new HashMap<>();
        customers.put(1, new Product(1, "Pen", 200, "Pen for student"));
        customers.put(2, new Product(2, "Mobile phone", 5000, "Samsung"));
        customers.put(3, new Product(3, "Book", 500, "Book for IT"));
        customers.put(4, new Product(4, "Laptop", 10000, "Laptop gaming"));
        customers.put(5, new Product(5, "Mouse", 300, "Mouse for play game"));
        customers.put(6, new Product(6, "Key-board", 900, "Key-board for play game"));
    }

    @Override
    public List<Product> findAll(){
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Product product){

        customers.put(product.getId(), product);
    }

    @Override
    public Product findById(int id){
        return customers.get(id);
    }

    @Override
    public  void update(int id, Product product){
        customers.put(id, product);

    }

    @Override
    public void remove(int id){
        customers.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        List<Product> products = findAll();
        for (Product product:products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(product);
            }
        }
        return result;
    }
}