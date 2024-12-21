package com.andersen.entities;

import com.andersen.enums.Role;
import lombok.Data;

@Data
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
        return "User {" +
                "\n\tid=" + id +
                "\n\tname='" + name + '\'' +
                "\n\trole=" + role +
                "\n\tlogin='" + login + '\'' +
                "\n}";
    }
}
