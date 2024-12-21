package com.andersen.repositories;

import com.andersen.entities.User;
import com.andersen.enums.Role;

import java.util.Arrays;
import java.util.List;

public class CustomerRepository {

    public static List<User> customers = Arrays.asList(
            new User(
                    "Andrew",
                    Role.CUSTOMER,
                    "andrew",
                    "qwerty"
            ),
            new User(
                    "Carlos",
                    Role.CUSTOMER,
                    "carlos",
                    "qwerty"
            )
    );
}
