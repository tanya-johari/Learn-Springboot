package com.example.mobilt.app.ws.userservice;

import com.example.mobilt.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.mobilt.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.mobilt.app.ws.ui.model.response.UserRest;

public interface UserService {
    UserRest getUser(String userId);

    UserRest createUser(UserDetailsRequestModel userDetails);

    UserRest updateUser(String userId, UpdateUserDetailsRequestModel userDetails);

    void deleteUser(String userId);
}
