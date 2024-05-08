package com.example.mobilt.app.ws.userservice.impl;

import com.example.mobilt.app.ws.exceptions.UserServiceException;
import com.example.mobilt.app.ws.shared.Utils;
import com.example.mobilt.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.mobilt.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.mobilt.app.ws.ui.model.response.UserRest;
import com.example.mobilt.app.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private Map<String, UserRest> users;
    private final Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest getUser(String userId) {
        if(users == null || !users.containsKey(userId)) {
            throw new UserServiceException("User not found with id " + userId);
        }
        return users.get(userId);
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {

        UserRest newUser = new UserRest();
        newUser.setEmail(userDetails.getEmail());
        newUser.setFirstName(userDetails.getFirstName());
        newUser.setLastName(userDetails.getLastName());

        String userId = utils.generateUserId();
        newUser.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, newUser);
        return newUser;
    }

    @Override
    public UserRest updateUser(String userId, UpdateUserDetailsRequestModel userDetails) {
        if(users == null || !users.containsKey(userId)) {
            throw new UserServiceException("User not found with id " + userId);
        }

        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());
        users.put(userId, storedUserDetails);
        return storedUserDetails;
    }

    @Override
    public void deleteUser(String userId) {
        users.remove(userId);
    }
}
