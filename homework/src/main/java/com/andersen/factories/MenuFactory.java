package com.andersen.factories;

import com.andersen.entities.User;
import com.andersen.menus.admin.AdminMenu;
import com.andersen.menus.customer.CustomerMenu;
import com.andersen.menus.IMenu;

public class MenuFactory {
    public static IMenu userMenu(User user) {
        return switch(user.getRole()) {
            case ADMIN -> new AdminMenu();
            case CUSTOMER -> new CustomerMenu();
        };
    }
}
