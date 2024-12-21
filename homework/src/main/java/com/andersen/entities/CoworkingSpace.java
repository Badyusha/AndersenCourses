package com.andersen.entities;

import com.andersen.enums.CoworkingSpaceType;
import lombok.Data;

@Data
public class CoworkingSpace {
    private static int nextId = 1;
    private int id;
    private CoworkingSpaceType type;
    private double price;
    private boolean isAvailable;
    private Book book;

    public CoworkingSpace(CoworkingSpaceType type, double price, boolean isAvailable, Book book) {
        this.id = nextId;
        ++nextId;
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
        this.book = book;
    }

    @Override
    public String toString() {
        return "CoworkingSpace {" +
                "\n\tid=" + id +
                "\n\ttype=" + type +
                "\n\tprice=" + price +
                "\n\tisAvailable=" + isAvailable +
                "\n\tbook=" + book +
                "\n}";
    }
}
