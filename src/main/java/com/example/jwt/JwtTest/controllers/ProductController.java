package com.example.jwt.JwtTest.controllers;

import com.example.jwt.JwtTest.models.Product;
import com.example.jwt.JwtTest.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable(value = "id")Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid Product product){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(product));

    }
}
