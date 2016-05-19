package aut.bme.hu.model;

import java.util.Date;

public class Registration extends User{


    private String password;

    public Registration(String name, String email, String description, Date birthDate, String password) {
        super(name, email, description, birthDate);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

