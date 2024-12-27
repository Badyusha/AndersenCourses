package com.andersen.repositories;

import com.andersen.entities.User;
import com.andersen.enums.Role;
import com.andersen.streams.files.UserFileStream;

import java.util.Arrays;
import java.util.List;

public class CustomerRepository {

    private static final String filePath = "customers.txt";

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

    public List<User> getCustomers() {
        return UserFileStream.readUsersFromFile(filePath);
    }

    public void writeCustomers(List<User> admins) {
        UserFileStream.writeUsersToFile(filePath, admins);
    }
}
