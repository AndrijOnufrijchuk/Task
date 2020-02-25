package com.example.demo.controller;

import com.example.demo.entity.InventoryListDTO;
import com.example.demo.repository.CategoryDao;
import com.example.demo.repository.InventoryListDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

    @Autowired
    CategoryDao categoryRepo;
    @Autowired
    InventoryListDAO inventoryListRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping("/category")
    public String category(Model model)
    {
        model.addAttribute("categories", categoryRepo.findAll());
        return "category";
    }

    @GetMapping("/inventory")
    public String inventory(Model model)
    {
        model.addAttribute("inventories", inventoryListRepo.findAll());
        return "inventory";
    }

    @GetMapping("/inventories")
    public String inventories(Model model)
    {
        model.addAttribute("inventories", inventoryListRepo.findAll());
        return "inventories";
    }

    @GetMapping("/delete/{id}")
    public String delete( int id, Model model ){
        model.addAttribute("inventories", inventoryListRepo.deleteById(id));

        return "inventories";
    }

   /* @RequestMapping("/edit/{id}")
    public String update( int id, Model model ){
        model.addAttribute("inventories", inventoryListRepo.update(inventoryListRepo.findById(id)));

        return "inventories";
    }*/

}
