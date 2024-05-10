package com.example.mobilt.app.ws.ui.model.response;

import com.example.mobilt.app.ws.shared.Utils;

public class UserRest {
    private String firstName;
    private String lastName;
    private String email;
    private final String userId;

    Utils utils = new Utils();

    public UserRest(String firstName, String lastName, String email) {
        this.userId = utils.generateUserId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }
}
