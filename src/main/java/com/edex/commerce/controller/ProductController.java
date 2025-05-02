package com.edex.commerce.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edex.commerce.dto.request.ProductRequestDto;
import com.edex.commerce.model.Product;
import com.edex.commerce.repo.ProductRepo;
import com.edex.commerce.service.impl.ProductServiceImpl;

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
/*
    @Autowired
    private Environment env;
    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/insert")
    public ResponseEntity<String> insert(@ModelAttribute ProductRequestDto dto) throws Exception{
        String uploadLocation = env.getProperty("resources.uploads.location");
        // String uploadLocation = "/home/kernelogy/learn/tallakulam/spring/commerce/src/main/resources/uploads/";
        Path path = Paths.get(uploadLocation + new Date().getTime() + dto.getImage().getOriginalFilename());
        // Path path = Paths.get(uploadLocation + dto.getImage().getOriginalFilename());
        Files.write(path, dto.getImage().getBytes());
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImage(path.getFileName().toString());
        productRepo.saveAndFlush(product);
        return ResponseEntity.ok().body("OK");
    }
*/       
    @Autowired
    private ProductServiceImpl productService;
    @PostMapping("/insert")
    public ResponseEntity<String> insert(@ModelAttribute ProductRequestDto dto){
        String result = productService.insert(dto);
        return ResponseEntity.ok().body(result);
    }
}


