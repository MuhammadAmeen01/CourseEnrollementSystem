import java.sql.*;

public class UserDatabase {
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3308/db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    // Function to create the user table
    public static void createUserTable() {
//        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             Statement stmt = conn.createStatement()) {
//            String sql = "CREATE TABLE users (" +
//                    "id INT AUTO_INCREMENT PRIMARY KEY," +
//                    "username VARCHAR(50) NOT NULL," +
//                    "first_name VARCHAR(50) NOT NULL," +
//                    "last_name VARCHAR(50) NOT NULL," +
//                    "student_number VARCHAR(10) NOT NULL," +
//                    "password VARCHAR(255) NOT NULL" +
//                    ")";
//            stmt.executeUpdate(sql);
//            System.out.println("User table created successfully.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    // Function to sign up a new user
    public boolean signup(String username, String firstName, String lastName, String studentNumber, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username, first_name, last_name, student_number, password) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, username);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, studentNumber);
            stmt.setString(5, password);
            stmt.executeUpdate();
            System.out.println("User signed up successfully.");
            return true;
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                System.out.println("Username already exists. Please choose a different username.");
            } else {
                e.printStackTrace();
            }
        }
        return false;
    }

    // Function to log in an existing user
    public boolean login(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful.");
                return true;
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        createUserTable();

//        // Test signup and login functions
//        signup("user1", "John", "Doe", "123456", "password123");
//        signup("user2", "Jane", "Smith", "987654", "password456");
//
//        login("user1", "password123");
//        login("user1", "wrongpassword");
//        login("user2", "password456");
    }
}
