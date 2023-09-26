package com.github.angel.raa.modules.prototype.models;

import com.github.angel.raa.modules.prototype.Prototype;

import java.util.Arrays;

public class Products implements Prototype {

    private String name;
    private String description;
    private int price;
    private String[] items;

    public Products(String name, String description, int price, String[] items) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    @Override
    public Prototype clone() {
        Products products = new Products(this.name, this.description, this.price, this.items.clone());
        return products;
    }

    @Override
    public Prototype deepClone() {
        return clone();
    }

    @Override
    public Prototype reset() {
        return clone();
    }

    @Override
    public String toString() {
        return Integer.toHexString( System.identityHashCode(this)) + "Products{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
