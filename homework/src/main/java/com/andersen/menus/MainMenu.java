package com.andersen.menus;

import com.andersen.factories.UserSession;
import com.andersen.entities.User;
import com.andersen.enums.Role;
import com.andersen.factories.MenuFactory;
import com.andersen.services.LoginService;
import com.andersen.services.ScannerService;

public class MainMenu implements IMenu {
    private final LoginService loginService = new LoginService();

    @Override
    public void display() {
        System.out.println("Welcome to the Coworking Space Reservation Application!");

        int menuOption = 0;
        while (menuOption != 3) {
            System.out.println("""
                    Choose menu option
                    1. Admin login
                    2. Customer login
                    3. Exit
                    > """);

            menuOption = ScannerService.scanner.nextInt();
            handleMainMenu(menuOption);
        }
    }

    private void handleMainMenu(int menuOption) {
        switch (menuOption) {
            case 1:
            case 2: {
                User user = loginService.loginUser(Role.values()[menuOption - 1]);
                if (user == null) {
                    System.out.println("Invalid username or password!");
                    break;
                }
                UserSession.getInstance().setUser(user);
                MenuFactory.userMenu(user).display();
                break;
            }
            case 3: { }
        }
    }
}
