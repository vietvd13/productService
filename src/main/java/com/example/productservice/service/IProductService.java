package com.example.productservice.service;

import com.example.productservice.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public Product addProduct(Product product);

    public Product updateProduct(Product product);

    public boolean deleteProduct(long id);

    public Optional<Product> getOneProduct(long id);

    public List<Product> getAllProduct();
}
