package com.example.crud.crudexample.controller;

import com.example.crud.crudexample.entity.Product;
import com.example.crud.crudexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/create")
    public Product create(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/product/create-all")
    public List<Product> creteAll(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> index(){
        return productService.getProducts();
    }

    @GetMapping("/product/id/{id}")
    public Product findProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @GetMapping("/product/name/{name}")
    public List<Product> findProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @DeleteMapping("/product/{id}")
    public String delete(@PathVariable int id){
        return productService.deleteProduct(id);
    }

    @PutMapping("/product/update")
    public Product update(@RequestBody Product product){
        return productService.updateProduct(product);
    }
}
