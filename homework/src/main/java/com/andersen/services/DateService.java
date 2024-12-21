package com.andersen.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateService {
    public static LocalDate dateInput(String userInput) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(userInput, dateFormat);
    }

    public static LocalTime timeInput(String userInput) {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("H:m");
        return LocalTime.parse(userInput, dateFormat);
    }
}
