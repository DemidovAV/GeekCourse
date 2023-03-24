package com.example.demospring.controllers;

public class Cat {
    long id;
    String name;

    String color;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat() {
    }

    public String getColor() {
        return color;
    }

    public Cat(long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
}
