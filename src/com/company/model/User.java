package com.company.model;

import java.util.Date;

public class User {
    private String userId;
    private String name;
    private String address;
    private Date dateOfBirth;

    public User(String userId, String name, String address, Date dateOfBirth) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
