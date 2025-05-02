package com.edex.commerce.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.edex.commerce.dto.request.ProductRequestDto;
import com.edex.commerce.model.Product;
import com.edex.commerce.repo.ProductRepo;
import com.edex.commerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private Environment env;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public String insert(ProductRequestDto dto) {
        String uploadLocation = env.getProperty("resources.uploads.location");
        // String uploadLocation = "/home/kernelogy/learn/tallakulam/spring/commerce/src/main/resources/uploads/";
        Path path = Paths.get(uploadLocation + new Date().getTime() + dto.getImage().getOriginalFilename());
        // Path path = Paths.get(uploadLocation + dto.getImage().getOriginalFilename());
        try {
            Files.write(path, dto.getImage().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImage(path.getFileName().toString());
        productRepo.saveAndFlush(product);        
        return "Product Saved Successfully";
    }
    
}
