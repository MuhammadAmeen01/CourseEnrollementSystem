import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Path;

public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String password;
     List<Course> enrolledCourses=new ArrayList<Course>();

    UserDatabase db=new UserDatabase();

    public User(String username, String firstName, String lastName, String studentNumber, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.password = password;
    }
    public User() {
    	
    }
    public void withdrawCourse(Course course) {
        // Remove the course from the enrolled courses list
        enrolledCourses.remove(course);

        // Update the user's text file
        saveUserCourseData();
    }
    public void saveUserCourseData() {
        // Prepare the data to be saved
        StringBuilder sb = new StringBuilder();
        for (Course course : enrolledCourses) {
            sb.append(course.getCourseName()).append(",")
                    .append(course.getCapacity()).append(",")
                    .append(course.getYear()).append(",")
                    .append(course.getDeliveryMode()).append(",")
                    .append(course.getDayOfLecture()).append(",")
                    .append(course.getTimeOfLecture()).append(",")
                    .append(course.getDuration()).append("\n");
        }

        // Write the data to the user's text file
        String fileName = username + ".txt";
        String directoryPath = "EnrolledStudents";
        Path filePath = (Path) Paths.get(directoryPath, fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toString()))) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public User(String str) {
    	username=str;
    }
    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    
    public boolean signup(String user1, String John, String Doe, String hehe, String password123) {
    	if(db.signup(user1, John, Doe, hehe, password123)) {
    		return true;
    	};
    	return false;
    	
    }
    public boolean login(String user1, String password123) {
    	if(db.login(user1,password123)) {
    		return true;
    	};
    	return false;
    	
    }
}
