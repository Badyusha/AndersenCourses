package com.andersen.streams.files;

import com.andersen.entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileStream {

    public static void writeUsersToFile(String filePath, List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : users) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> readUsersFromFile(String filePath) {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                users.add(User.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
