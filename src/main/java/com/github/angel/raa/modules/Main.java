package com.github.angel.raa.modules;

import com.github.angel.raa.modules.singleton.Connector;

public class Main {
    public static void main(String[] args) {
        Connector connector1 = Connector.getInstance();
        Connector connector2 = Connector.getInstance();
        System.out.println(connector1 == connector2); // true


    }
}