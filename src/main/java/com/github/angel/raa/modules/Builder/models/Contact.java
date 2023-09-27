package com.github.angel.raa.modules.Builder.models;

public class Contact {
    private String phone;
    private String email;
    private String linkedin;


    public Contact() {}



    public Contact(String phone, String email, String linkedin) {
        this.phone = phone;
        this.email = email;
        this.linkedin = linkedin;

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }



    @Override
    public String toString() {
        return "Contact Information:\n" +
                "Phone: " + phone + "\n" +
                "Email: " + email + "\n" +
                "LinkedIn: " + linkedin;
    }


}
