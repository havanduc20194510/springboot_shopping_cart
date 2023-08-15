package com.example.shopping_cart_demo.controller;

import com.example.shopping_cart_demo.entity.Product;
import com.example.shopping_cart_demo.model.Cart;
import com.example.shopping_cart_demo.model.CartItem;
import com.example.shopping_cart_demo.service.CartManager;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartManager cartManager;

    @RequestMapping("/view")
    public String cart(HttpSession session, Model model){
        Cart cart = cartManager.getCart(session);
        List<CartItem> cartItems = cart.getItems();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", cart.getTotal());
        return "cart";
    }

    @RequestMapping("/add")
    public String add(HttpSession session, @RequestParam("id") Product product,
                      @RequestParam(value = "qty", required = false, defaultValue = "1") int qty){
        Cart cart = cartManager.getCart(session);
        cart.addItem(product, qty);
        return "cart";
    }

    @RequestMapping("/remove")
    public String remove(HttpSession session, @RequestParam("id") Product product){
        Cart cart = cartManager.getCart(session);
        cart.removeItem(product);
        return "cart";
    }

    @RequestMapping("/update")
    public String update(HttpSession session, @RequestParam("id") Product product, @RequestParam("qty") int qty){
        Cart cart = cartManager.getCart(session);
        cart.updateItem(product, qty);
        return "cart";
    }

}
