package com.github.angel.raa.modules;

import com.github.angel.raa.modules.singleton.Connector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connector connector = Connector.getInstance();
        connector.connect();
        connector.disconnect();

    }




}