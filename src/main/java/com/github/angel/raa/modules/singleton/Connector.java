package com.github.angel.raa.modules.singleton;

public class Connector {
    private static volatile Connector instance;

    private Connector() {
        System.out.println("Connector created");
    }

    public static Connector getInstance() {
        if (instance == null) {
            synchronized (Connector.class) {
                if (instance == null) {
                    instance = new Connector();
                }
            }
        }
        return instance;
    }

    private static void validateInstance() {
        if (instance == null) {
            throw new IllegalStateException("Connector is not initialized");
        }
    }

    public void connect() {
        validateInstance();
        System.out.println("Connecting.....");


    }

    public void disconnect() {
        validateInstance();
        System.out.println("Disconnecting.....");
    }
}
