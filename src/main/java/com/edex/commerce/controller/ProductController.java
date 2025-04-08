package com.edex.commerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
