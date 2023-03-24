package com.example.demospring.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class MainController {

    @GetMapping("/index")
    public String startPage(){
        return "index";
    }

    @GetMapping("/hello/{title}/{name}")
    public String hello(Model model, @PathVariable(value = "title") String title, @PathVariable(value = "name") String name) {
        model.addAttribute("title", title);
        model.addAttribute("name", name);
        return "hello";
    }

//    @GetMapping("/error")
//    public String errorMessage() {
//        return "error";
//    }

    @GetMapping("/form")
    public String simpleForm() {
        return "simple-form";
    }

    @PostMapping("/form")
    public String saveForm(@RequestParam(value="name") String name, @RequestParam(value="email") String email) {
        System.out.println(name);
        System.out.println(email);
        return "redirect:/index";
    }

    @GetMapping("/addcat")
    public String showAddCatForm(Model model) {
        Cat cat = new Cat(1, null, null);
        model.addAttribute("cat", cat);
        return "cat-form";
    }

    @PostMapping("/addcat")
    public String showAddCatForm(@ModelAttribute(value = "cat") Cat cat) {
        System.out.println("id =" + cat.getId() + ", name = " + cat.getName() + ", color = " + cat.getColor());
        return "redirect:/index";
    }
}
