package com.andersen.services;

import com.andersen.entities.User;
import com.andersen.enums.Role;
import com.andersen.repositories.AdminRepository;
import com.andersen.repositories.CustomerRepository;

import java.util.stream.Stream;

public class LoginService {

    public User loginUser(Role role) {
        System.out.print("Enter login: ");
        String login = ScannerService.scanner.next();
        System.out.print("Enter password: ");
        String password = ScannerService.scanner.next();

        Stream<User> stream =  switch (role) {
            case ADMIN -> {
                 AdminRepository adminRepository = new AdminRepository();
                 yield AdminRepository.admins.stream();
            }
            case CUSTOMER -> {
                CustomerRepository customerRepository = new CustomerRepository();
                yield CustomerRepository.customers.stream();
            }
        };

        return stream
                .filter(u -> u.getLogin().equals(login) &&
                             u.getPassword().equals(password)
                )
                .findFirst().orElse(null);
    }
}
