package com.example.lesson15.controllers;

import com.example.lesson15.entities.Item;
import com.example.lesson15.repositories.specifications.ItemSpecs;
import com.example.lesson15.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String showItems(Model model) {
        Specification<Item> spec = Specification.where(null);
        spec = spec.and(ItemSpecs.costGreaterThanOrEquals(30L));
        List<Item> listOfItems = itemService.getItemsWithPaginationAndFiltering(spec, PageRequest.of(1, 2)).getContent();
        model.addAttribute("items", listOfItems);
        return "items";
    }
}
