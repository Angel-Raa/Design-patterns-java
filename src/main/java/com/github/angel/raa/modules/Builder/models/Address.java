package com.github.angel.raa.modules.Builder.models;

public class Address {
    private String street;
    private String city;
    private String state;
    private String country;

    public Address() {}

    public Address(String street, String city, String state, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address Information:\n" +
                "Street: " + street + "\n" +
                "City: " + city + "\n" +
                "State: " + state + "\n" +
                "country: " + country;
    }

}
