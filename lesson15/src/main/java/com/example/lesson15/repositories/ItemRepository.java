package com.example.lesson15.repositories;

import com.example.lesson15.entities.Item;
import com.example.lesson15.entities.ItemProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public interface ItemRepository extends JpaRepository<Item, Long> {
//    Item findByTitle(String title);
//    List<Item> findByCostBetween(Long min, Long max); //пример написания "своего" метода (но по образцу)
//    List<Item> findByTitleAndCost(String title, Long cost);
//    List<Item> findByCostOrderByTitleDesc(Long cost);
//
////    @Query("тут JPQL запрос", nativeQuery = true - c этой опцией запрос будет не JPQL, а SQL)
////    List<Item> myQuery();
//}
@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long>, JpaSpecificationExecutor<Item> {
    List<ItemProjection> asdasd();
}

