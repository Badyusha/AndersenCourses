package com.andersen.entities;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Book {
    private static int nextId = 1;
    private int id;
    private String name;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private User customer;

    public Book(String name, LocalDate date, LocalTime startTime, LocalTime endTime, User customer) {
        this.id = nextId;
        ++nextId;
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Book {" +
                "\n\tid=" + id +
                "\n\tname='" + name + '\'' +
                "\n\tdate=" + date +
                "\n\tstartTime=" + startTime +
                "\n\tendTime=" + endTime +
                "\n\tcustomer=" + customer +
                "\n}";
    }
}
