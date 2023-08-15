package com.example.shopping_cart_demo.controller;

import com.example.shopping_cart_demo.dao.ProductRepository;
import com.example.shopping_cart_demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping({"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "shop";
    }

    @RequestMapping("/cart")
    public String cart(){
        return "cart";
    }

    @RequestMapping("/product/{id}")
    public String product(@PathVariable("id") Product product, Model model){
        model.addAttribute("product", product);
        return "product";
    }
}
