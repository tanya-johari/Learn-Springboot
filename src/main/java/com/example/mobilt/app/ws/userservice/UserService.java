package com.example.mobilt.app.ws.userservice;

import com.example.mobilt.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.mobilt.app.ws.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
