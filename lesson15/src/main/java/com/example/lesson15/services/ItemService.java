package com.example.lesson15.services;

import com.example.lesson15.entities.Item;
import com.example.lesson15.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        System.out.println(itemRepository.findByTitle("Tree"));
        System.out.println(itemRepository.findByCostBetween(10L, 50L));
        return itemRepository.findAll();
    }
}
