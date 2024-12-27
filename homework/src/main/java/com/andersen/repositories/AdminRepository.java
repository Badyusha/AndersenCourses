package com.andersen.repositories;

import com.andersen.entities.User;
import com.andersen.enums.Role;

import java.util.Arrays;
import java.util.List;

public class AdminRepository {

    public static List<User> admins = Arrays.asList(
            new User(
                    "Smith",
                    Role.ADMIN,
                    "smith",
                    "qwerty"
            ),
            new User(
                    "Mike",
                    Role.ADMIN,
                    "mike",
                    "qwerty"
            )
    );
}
