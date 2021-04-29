package com.company.service;

import java.util.HashSet;
import java.util.Set;

public class LoginService {
    Set<String> activeUserIds;

    public LoginService() {
        this.activeUserIds = new HashSet<>();
    }

    public void logInUser(String userId){
        activeUserIds.add(userId);
    }

    public void logOutUser(String userId){
        activeUserIds.remove(userId);
    }

    public boolean isLoggedIn(String userId){
        return activeUserIds.contains(userId);
    }
}
