package user;
import java.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class user {
    private String username;
    private String password;

    // Constructor
    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method to register a new user
    public static void registerUser(String username, String password) {
        Map<String, String> users = loadUsers();

        if (!users.containsKey(username)) {
            users.put(username, password);
            saveUsers(users);
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    // Save user data to a file
    private static void saveUsers(Map<String, String> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat"))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load user data from a file
    @SuppressWarnings("unchecked")
    private static Map<String, String> loadUsers() {
        Map<String, String> users = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.dat"))) {
            users = (Map<String, String>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No user data file found. A new one will be created.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
