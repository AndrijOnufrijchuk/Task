package com.example.demo.controller;

import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.InventoryListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GreetingController {

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    InventoryListRepo inventoryListRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    @RequestMapping("/category")
    public String category(Model model)
    {
        model.addAttribute("categories", categoryRepo.findAll());
        return "category";
    }

    @RequestMapping("/inventory")
    public String inventory(Model model)
    {
        model.addAttribute("inventories", inventoryListRepo.findAll());
        return "inventory";
    }

    @RequestMapping("/inventories")
    public String inventories(Model model)
    {
        model.addAttribute("inventories", inventoryListRepo.findAll());
        return "inventories";
    }

}
