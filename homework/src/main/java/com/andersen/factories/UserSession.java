package com.andersen.factories;

import com.andersen.entities.User;
import lombok.Getter;
import lombok.Setter;

public class UserSession {
    public static UserSession instance = null;
    @Getter @Setter
    private User user;

    private UserSession() {}

    public static UserSession getInstance() {
        if(instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
}
