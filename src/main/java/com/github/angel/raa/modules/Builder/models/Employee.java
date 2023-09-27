package com.github.angel.raa.modules.Builder.models;


import com.github.angel.raa.modules.Builder.interfaces.IBuilder;

public class Employee {
    private String name;
    private int age;
    private String gender;
    private Contact contact;
    private Address address;

    public Employee() {
    }

    public Employee(String name, int age, String gender, Contact contact, Address address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee Information:\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Gender: " + gender + "\n" +
                "Contact: " + contact + "\n" +
                "Address: " + address;
    }

    public static class EmployeeBuilder implements IBuilder<Employee> {
        private String name;
        private int age;
        private String gender;
        private Contact contact;
        private Address address;

        public EmployeeBuilder() {
        }

        public EmployeeBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public EmployeeBuilder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public EmployeeBuilder setContact(String phone, String email, String linkedin) {
            this.contact = new Contact(phone, email, linkedin);
            return this;
        }

        public EmployeeBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder setAddress(String street, String city, String state, String country) {
            this.address = new Address(street, city, state, country);
            return this;
        }

        @Override
        public Employee build() {
            return new Employee(name, age, gender, contact, address);
        }
    }

}
