package com.example.lesson15.repositories;

import com.example.lesson15.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByTitle(String title);
    List<Item> findByCostBetween(Long min, Long max); //пример написания "своего" метода (но по образцу)
    List<Item> findByTitleAndCost(String title, Long cost);

//    @Query("тут PostgresQL запрос")
//    List<Item> myQuery();
}
