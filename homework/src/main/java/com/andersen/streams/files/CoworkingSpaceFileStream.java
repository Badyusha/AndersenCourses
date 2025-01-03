package com.andersen.streams.files;

import com.andersen.entities.Book;
import com.andersen.entities.CoworkingSpace;
import com.andersen.entities.User;
import com.andersen.enums.CoworkingSpaceType;
import com.andersen.enums.Role;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CoworkingSpaceFileStream {

    private static final String filePath = "coworking_space.txt";

    public static List<CoworkingSpace> getCoworkingSpaces() {
        List<CoworkingSpace> coworkingSpaces = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                CoworkingSpaceType type = CoworkingSpaceType.valueOf(line);
                double price = Double.parseDouble(reader.readLine());
                boolean isAvailable = Boolean.parseBoolean(reader.readLine());
                Book book = null;
                line = reader.readLine();
                if(line.equals("null")) {
                    coworkingSpaces.add(new CoworkingSpace(type, price, isAvailable, book));
                    continue;
                }
                int id = Integer.parseInt(line);
                String name = reader.readLine();
                LocalDate date = LocalDate.parse(reader.readLine());
                LocalTime startTime = LocalTime.parse(reader.readLine());
                LocalTime endTime = LocalTime.parse(reader.readLine());

                User customer = null;
                if (!"null".equals(reader.readLine())) {
                    int userId = Integer.parseInt(reader.readLine());
                    String userName = reader.readLine();
                    Role userRole = Role.valueOf(reader.readLine());
                    String userLogin = reader.readLine();
                    String userPassword = reader.readLine();
                    customer = new User(userId, userName, userRole, userLogin, userPassword);
                }

                book = new Book(id, name, date, startTime, endTime, customer);

                coworkingSpaces.add(new CoworkingSpace(type, id, isAvailable, book));
            }
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return coworkingSpaces;
    }

    public static void writeCoworkingSpace(CoworkingSpace coworkingSpace) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(coworkingSpace.getType().name());
            writer.newLine();
            writer.write(String.valueOf(coworkingSpace.getPrice()));
            writer.newLine();
            writer.write(String.valueOf(coworkingSpace.isAvailable()));
            writer.newLine();
            Book book = coworkingSpace.getBook();
            if (book != null) {
                writer.write(String.valueOf(book.getId()));
                writer.newLine();
                writer.write(book.getName());
                writer.newLine();
                writer.write(book.getDate().toString());
                writer.newLine();
                writer.write(book.getStartTime().toString());
                writer.newLine();
                writer.write(book.getEndTime().toString());
            } else {
                writer.write("null");
            }
            writer.newLine();
            System.out.println("CoworkingSpace object written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
