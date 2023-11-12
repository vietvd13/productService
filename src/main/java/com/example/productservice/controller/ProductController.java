package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String test() {
        return "API Product";
    }

    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product) {
        return iProductService.addProduct(product);
    }

    @PostMapping("/update-product")
    public Product updateProduct(@RequestBody Product product) {
        return iProductService.updateProduct(product);
    }

    @PostMapping("/delete-product")
    public boolean deleteProduct(@RequestBody long id) {
        return iProductService.deleteProduct(id);
    }

    @GetMapping("/get-product/{id}")
    public Optional<Product> getOneProduct(@PathVariable long id) {
        return iProductService.getOneProduct(id);
    }

    @GetMapping("/get-all-product")
    public List<Product> getAllProduct() {
        return iProductService.getAllProduct();
    }
}
