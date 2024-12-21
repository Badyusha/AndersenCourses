package com.andersen.menus.admin;

import com.andersen.factories.UserSession;
import com.andersen.menus.IMenu;
import com.andersen.services.CoworkingSpaceService;
import com.andersen.services.ScannerService;

public class AdminMenu implements IMenu {
    private final CoworkingSpaceService coworkingSpaceService = new CoworkingSpaceService();

    @Override
    public void display() {
        int menuOption = 0;
        while (menuOption != 5) {
            System.out.print("Admin Menu:\n" +
                    "1. Add a new coworking space\n" +
                    "2. Remove coworking space\n" +
                    "3. Update coworking space\n" +
                    "4. View all reservations\n" +
                    "5. Log out\n" +
                    "> ");
            menuOption = ScannerService.scanner.nextInt();
            handleAdminMenuOption(menuOption);
        }
    }

    private void handleAdminMenuOption(int option) {
        switch (option) {
            case 1: {
                coworkingSpaceService.addCoworkingSpace();
                break;
            }
            case 2: {
                coworkingSpaceService.removeCoworkingSpace();
                break;
            }
            case 3: {
                coworkingSpaceService.updateCoworkingSpace();
                break;
            }
            case 4: {
                coworkingSpaceService.viewAllReservedSpaces();
                break;
            }
            case 5 : {
                UserSession.getInstance().setUser(null);
            }
            default: {
                break;
            }
        }
    }
}
