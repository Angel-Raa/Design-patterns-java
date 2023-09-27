package com.github.angel.raa.modules;

import com.github.angel.raa.modules.Builder.models.Address;
import com.github.angel.raa.modules.Builder.models.Contact;
import com.github.angel.raa.modules.Builder.models.Employee;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee.EmployeeBuilder()
                .setName("Angel Aguero")
                .setAge(22)
                .setGender("M")
                .setAddress(new Address("123 Main St", "Example", "Santo Domingo", "RD"))
                .setContact(new Contact("800-999-1212", "angel.@gmail.com", "com.angel.profile"))
                .build();
        System.out.println(employee);


    }
}