package com.example.mobilt.app.ws.ui.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

    @NotNull(message = "first name cannot be null")
    @Size(min = 2, message = "first name must not be less than 2 characters.")
    private String firstName;

    @NotNull(message = "last name cannot be null")
    @Size(min = 2, message = "last name must not be less than 2 characters.")
    private String lastName;

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
}
