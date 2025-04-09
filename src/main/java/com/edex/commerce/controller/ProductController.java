package com.edex.commerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edex.commerce.model.Product;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @GetMapping("/get")
    public Product getProduct(){    
        Product product = new Product("Cotton Shirt", "Pure Cotton Shirt", 599.99, "shirt1.jpg");
        return product;
    }
    @GetMapping("/getResp")
    public ResponseEntity<Product> getProductResponse(){
        Product product = new Product("Cotton Shirt", "Pure Cotton Shirt", 599.99, "shirt1.jpg");
        //The below creates an Internal Server Error with HTTP status code 500
        // int[] x = {1,2,3,4,5};
        // System.out.println(x[5]);
        return ResponseEntity.status(HttpStatus.OK)
                .header("edex-header", "Welcome to edex")
                .body(product);       
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){
        List<Product> products = new ArrayList<>();
        products.add(new Product("Cotton Shirt", "Pure Cotton Shirt", 599.99, "shirt1.jpg"));
        products.add(new Product("Linen Shirt", "Pure Linen Shirt", 599.99, "shirt2.jpg"));
        products.add(new Product("Polyster Shirt", "Polyster Shirt", 599.99, "shirt3.jpg"));
        return ResponseEntity.ok().body(products.get(id));
    }

}
