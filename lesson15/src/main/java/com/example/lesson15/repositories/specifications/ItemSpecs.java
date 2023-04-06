package com.example.lesson15.repositories.specifications;

import com.example.lesson15.entities.Item;
import org.springframework.data.jpa.domain.Specification;

import static antlr.build.ANTLR.root;

public class ItemSpecs {
    public static Specification<Item> titleContains(String word) {
        return (Specification<Item>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("title"), "%" + word + "%");
    }

    public static Specification<Item> costGreaterThanOrEquals(Long value) {
        return (Specification<Item>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), value);
    }
}

