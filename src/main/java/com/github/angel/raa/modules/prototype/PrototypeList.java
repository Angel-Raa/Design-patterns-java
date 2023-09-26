package com.github.angel.raa.modules.prototype;

import com.github.angel.raa.modules.prototype.models.Products;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrototypeList implements Prototype {
    private String name;
    private List<Products> productsList;

    public PrototypeList(String name) {
        this.name = name;
    }

    @Override
    public Prototype clone() {
        PrototypeList clone = new PrototypeList(name);
        clone.setProducts(productsList);
        return clone;
    }

    @Override
    public Prototype deepClone() {
        PrototypeList clone = new PrototypeList(name);
        List<Products> products = new ArrayList<>();
        List<Prototype> values = productsList.stream()
                .map(Products::clone).collect(Collectors.toList());
        products.add((Products) values);
        clone.setProducts(products);
        return clone;
    }

    @Override
    public Prototype reset() {
        if (productsList.isEmpty()) {
            return null;
        }

        PrototypeList clone = new PrototypeList(name);
        List<Products> products = new ArrayList<>();
        products.addAll(productsList);
        clone.setProducts(products);

        return clone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Products> getProducts() {
        return productsList;
    }

    public void setProducts(List<Products> products) {
        this.productsList = products;
    }

    @Override
    public String toString() {
        return Integer.toHexString(System.identityHashCode(this) )+  "\nPrototypeList{" +
                "name='" + name + '\'' +
                ", productsList=" + productsList +
                '}';
    }
}
