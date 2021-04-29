package com.company.Repository;

import com.company.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryInMemory implements UserRepository{
    private Map<String, User> userMap;

    public UserRepositoryInMemory() {
        this.userMap = new HashMap<>();
    }

    public void addUserToMap(User user){
        userMap.put(user.getUserId(), user);
    }

    @Override
    public User getUser(String userId) {
        return userMap.get(userId);
    }
}
