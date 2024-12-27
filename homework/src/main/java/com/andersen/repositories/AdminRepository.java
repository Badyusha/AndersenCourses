package com.andersen.repositories;

import com.andersen.entities.User;
import com.andersen.enums.Role;
import com.andersen.streams.files.UserFileStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminRepository {

    private static final String filePath = "admins.txt";

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

    public List<User> getAdmins() {
        return UserFileStream.readUsersFromFile(filePath);
    }

    public void writeAdmins(List<User> admins) {
        UserFileStream.writeUsersToFile(filePath, admins);
    }
}
