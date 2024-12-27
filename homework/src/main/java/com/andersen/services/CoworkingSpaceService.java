package com.andersen.services;

import com.andersen.entities.Book;
import com.andersen.entities.CoworkingSpace;
import com.andersen.enums.CoworkingSpaceType;
import com.andersen.factories.UserSession;
import com.andersen.repositories.CoworkingSpaceRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CoworkingSpaceService {
    public void addCoworkingSpace() {
        CoworkingSpace coworkingSpace = fillInCoworkingSpace();
        CoworkingSpaceRepository.coworkingSpaces.add(coworkingSpace);
        System.out.println("Coworking space successfully added!");
    }

    public void removeCoworkingSpace() {
        List<CoworkingSpace> coworkingSpaces = removeConcreteCoworkingSpace();
        if(coworkingSpaces == null) {
            return;
        }

        CoworkingSpaceRepository.coworkingSpaces = coworkingSpaces;

        System.out.println("Coworking space successfully removed!");
    }

    public void updateCoworkingSpace() {
        List<CoworkingSpace> coworkingSpaces = removeConcreteCoworkingSpace();
        if(coworkingSpaces == null) {
            return;
        }

        CoworkingSpace updatedCoworkingSpace = fillInCoworkingSpace();
        coworkingSpaces.add(updatedCoworkingSpace);
        CoworkingSpaceRepository.coworkingSpaces = coworkingSpaces;

        System.out.println("Coworking space successfully updated!");
    }

    public void viewAllReservedSpaces() {
        List<CoworkingSpace> coworkingSpaces = CoworkingSpaceRepository.coworkingSpaces;
        System.out.println("List of all reserved spaces: ");
        coworkingSpaces.stream().filter(c -> !c.isAvailable()).forEach(System.out::println);
    }

    public void viewAvailableSpaces() {
        List<CoworkingSpace> coworkingSpaces = CoworkingSpaceRepository.coworkingSpaces;
        if(coworkingSpaces.isEmpty()) {
            System.out.println("List of available spaces is empty!");
            return;
        }
        coworkingSpaces.stream().filter(c -> c.isAvailable()).forEach(System.out::println);
    }

    public void makeReservation() {
        List<CoworkingSpace> coworkingSpaces = CoworkingSpaceRepository.coworkingSpaces;
        CoworkingSpace coworkingSpace = getCoworkingSpaceById(coworkingSpaces);
        if(coworkingSpace == null) {
            System.out.println("Coworking space not found!");
            return;
        }

        coworkingSpace.setAvailable(false);
        coworkingSpace.setBook(fillInBook());

        System.out.println("Reservation successfully made!");
    }

    public void viewCustomerReservations() {
        List<CoworkingSpace> customerCoworkingSpaces = getCustomerReservations();
        if(customerCoworkingSpaces == null) {
            System.out.println("List of all customer reservations is empty!");
            return;
        }
        System.out.println("Available customer reservations: " + customerCoworkingSpaces);
    }

    public void cancelReservation() {
        List<CoworkingSpace> coworkingSpaces = CoworkingSpaceRepository.coworkingSpaces;
        CoworkingSpace coworkingSpace = getCoworkingSpaceById(coworkingSpaces);
        if(coworkingSpace == null) {
            System.out.println("Coworking space not found!");
            return;
        }
        coworkingSpace.setAvailable(true);
        coworkingSpace.setBook(null);
    }


    private List<CoworkingSpace> getCustomerReservations() {
        List<CoworkingSpace> coworkingSpaces = CoworkingSpaceRepository.coworkingSpaces;
        return coworkingSpaces.stream()
                .filter(c -> c.getBook() != null &&
                        c.getBook().getCustomer() != null &&
                        c.getBook().getCustomer().getId() == UserSession.getInstance().getUser().getId())
                .toList();
    }

    private Book fillInBook() {
        System.out.print("Enter name of the book: ");
        ScannerService.scanner.nextLine();
        String name = ScannerService.scanner.nextLine();

        System.out.print("Enter date in format 'M/d/yyyy': ");
        LocalDate date = DateService.dateInput(ScannerService.scanner.next());

        System.out.print("Enter start time in format 'H:m': ");
        LocalTime startTime = DateService.timeInput(ScannerService.scanner.next());

        System.out.print("Enter end time in format 'H:m': ");
        LocalTime endTime = DateService.timeInput(ScannerService.scanner.next());

        return new Book(name, date, startTime, endTime, UserSession.getInstance().getUser());
    }

    private List<CoworkingSpace> removeConcreteCoworkingSpace() {
        List<CoworkingSpace> coworkingSpaces = CoworkingSpaceRepository.coworkingSpaces;
        if(coworkingSpaces.isEmpty()) {
            System.out.println("List of coworking spaces is empty!");
            return null;
        }

        CoworkingSpace choosedCoworkingSpace = getCoworkingSpaceById(coworkingSpaces);
        if(choosedCoworkingSpace == null) {
            System.out.println("Coworking space not found!");
            return null;
        }

        coworkingSpaces.remove(choosedCoworkingSpace);
        return coworkingSpaces;
    }

    private CoworkingSpace fillInCoworkingSpace() {
        System.out.println("Choose coworking space type:");
        for (int i = 0; i < CoworkingSpaceType.values().length; ++i) {
            System.out.println(i + "." + CoworkingSpaceType.values()[i].name());
        }
        CoworkingSpaceType coworkingSpaceType = CoworkingSpaceType.values()[ScannerService.scanner.nextInt()];

        System.out.print("Enter coworking space price: ");
        double coworkingSpacePrice = Double.parseDouble(ScannerService.scanner.next());

        System.out.print("Enter 'true' if space is available or 'false' if it is not: ");
        boolean isAvailable = Boolean.parseBoolean(ScannerService.scanner.next());

        return new CoworkingSpace(coworkingSpaceType, coworkingSpacePrice, isAvailable, null);
    }

    private CoworkingSpace getCoworkingSpaceById(List<CoworkingSpace> coworkingSpaces) {
        System.out.println(coworkingSpaces);
        System.out.print("Enter id of coworking space: ");

        int coworkingSpaceId = ScannerService.scanner.nextInt();
        return coworkingSpaces.stream()
                .filter(c -> c.getId() == coworkingSpaceId)
                .findFirst().orElse(null);
    }
}
