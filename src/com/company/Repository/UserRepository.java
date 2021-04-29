package com.company.Repository;

import com.company.model.User;

import java.util.Map;

public interface  UserRepository {
    User getUser(String userId);
    void addUserToMap(User user);
}
