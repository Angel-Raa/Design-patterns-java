package com.github.angel.raa.modules;

import com.github.angel.raa.modules.prototype.PrototypeList;
import com.github.angel.raa.modules.prototype.models.Products;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Listado
        PrototypeList list = new PrototypeList("Listado");
        List<Products> productsList =
                List.of(new Products("Producto 1","Este es el primer producto.", 100, new String[]{"Item 1", "Item 2"}),
                new Products("Producto 2", "Este es el segundo producto.", 200, new String[]{"Item 1", "Item 2"}));

        list.setProducts(productsList);
        System.out.println(list);
        //Clonado
        PrototypeList clone = (PrototypeList) list.clone();
        for(Products product: clone.getProducts()){
            product.setPrice(product.getPrice() * 2);
        }
        System.out.println(clone);

    }
}