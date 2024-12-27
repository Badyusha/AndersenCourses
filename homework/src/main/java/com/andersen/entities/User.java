package com.andersen.entities;

import com.andersen.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private static int nextId = 1;
    private int id;
    private String name;
    private Role role;
    private String login;
    private String password;

    public User(String name, Role role, String login, String password) {
        this.id = nextId;
        ++nextId;
        this.name = name;
        this.role = role;
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + role + "," + login + "," + password;
    }

    public static User fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid line format: " + line);
        }
        return new User(
                Integer.parseInt(parts[0]),
                parts[1],
                Role.valueOf(parts[2]),
                parts[3],
                parts[4]
        );
    }
}
