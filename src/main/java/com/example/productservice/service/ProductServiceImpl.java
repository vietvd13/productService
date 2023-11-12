package com.example.productservice.service;

import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        if (product != null) {
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        if (product != null) {
            long id = product.getId();
            Product oldProduct = productRepository.getById(id);

            oldProduct.setName(product.getName());
            oldProduct.setPrice(product.getPrice());

            return productRepository.save(oldProduct);
        }

        return null;
    }

    @Override
    public boolean deleteProduct(long id) {
        if (id >= 1) {
            boolean isExit = productRepository.existsById(id);

            if (isExit) {
                productRepository.deleteById(id);

                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Product> getOneProduct(long id) {
        if (id >= 1) {
            return productRepository.findById(id);
        }

        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
