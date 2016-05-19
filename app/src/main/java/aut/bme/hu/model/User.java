package aut.bme.hu.model;

import java.util.Date;


public class User {
    private String name;
    private String email;

    private String description;
    private Date birthDate;


    public User(String name, String email, String description, Date birthDate) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
