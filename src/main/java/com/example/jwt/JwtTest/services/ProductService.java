package com.example.jwt.JwtTest.services;

import com.example.jwt.JwtTest.controllers.ProductController;
import com.example.jwt.JwtTest.models.Product;
import com.example.jwt.JwtTest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        var products = repository.findAll();
        for(Product product : products){
            var id = product.getId();
            product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
        }
        return products;
    }

    public Product findById(Long id){
        return repository.findById(id)
                .orElseThrow()
                .add(linkTo(methodOn(ProductController.class).getAllProducts()).withRel("Product list"));
    }
    public Product save(Product product){
        var newProduct = repository.save(product);
        newProduct.add(linkTo(methodOn(ProductController.class).getAllProducts()).withRel("Product list"));
        return newProduct;
    }
}
