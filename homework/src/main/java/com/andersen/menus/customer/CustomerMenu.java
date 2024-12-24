package com.andersen.menus.customer;

import com.andersen.entities.User;
import com.andersen.factories.UserSession;
import com.andersen.menus.IMenu;
import com.andersen.services.CoworkingSpaceService;
import com.andersen.services.ScannerService;

public class CustomerMenu implements IMenu {
    private final CoworkingSpaceService coworkingSpaceService = new CoworkingSpaceService();

    @Override
    public void display() {
        int menuOption = 0;
        while (menuOption != 5) {
            System.out.print("""
                    Customer Menu:\n
                    1. View available spaces\n
                    2. Make a reservation\n
                    3. View my reservations\n
                    4. Cancel reservation\n
                    5. Log out\n
                    > """);
            menuOption = ScannerService.scanner.nextInt();
            handleCustomerMenuOption(menuOption);
        }
    }

    private void handleCustomerMenuOption(int option) {
        switch (option) {
            case 1: {
                coworkingSpaceService.viewAvailableSpaces();
                break;
            }
            case 2: {
                coworkingSpaceService.makeReservation();
                break;
            }
            case 3: {
                coworkingSpaceService.viewCustomerReservations();
                break;
            }
            case 4: {
                coworkingSpaceService.cancelReservation();
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
