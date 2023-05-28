import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class logincontroller {
	//
	public Stage appStage;
	public Scene scene;
	public Parent root;
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    private static User currentUser; // Add a field to keep track of the logged-in user

    // ...

    @FXML
    private void loginButtonClicked(ActionEvent e) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Perform login logic here
        if (isValidCredentials(username, password)) {
            System.out.println("Login successful");
            root = FXMLLoader.load(getClass().getResource("MainView2.fxml"));
            appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            appStage.setScene(scene);
            appStage.show();

            currentUser = new User(username); // Create a User instance for the logged-in user

            // Create user text file if it doesn't exist
            String fileName = username + ".txt";
            String directoryPath = "EnrolledStudents";
            Path filePath = Paths.get(directoryPath, fileName);
            if (!Files.exists(filePath)) {
                Files.createDirectories(filePath.getParent());
                Files.createFile(filePath);
            }

            // Navigate to the next screen or perform any other actions
        } else {
            System.out.println("Invalid credentials");
            // Display an error message or perform any other actions
        }
    }
    private boolean isValidCredentials(String username, String password) {
        String username1 = usernameField.getText();
        String password1 = passwordField.getText();
        User newuser=new User();
        if(newuser.login(username1,password1)) {
        	return true;
        }
        return false;
    }
    
    @FXML
    private TableView<Course> tableViewCourses=new TableView<Course>();

    @FXML
    private TableColumn<Course, String> colCourseName=new TableColumn<Course,String>();

    @FXML
    private TableColumn<Course, Integer> colCapacity=new TableColumn<Course,Integer>();

    @FXML
    private TableColumn<Course, String> colYear=new TableColumn<Course,String>();

    @FXML
    private TableColumn<Course, String> colDeliveryMode=new TableColumn<Course,String>();;

    @FXML
    private TableColumn<Course, String> colDayOfLecture=new TableColumn<Course,String>();;

    @FXML
    private TableColumn<Course, String> colTimeOfLecture=new TableColumn<Course,String>();;

    @FXML
    private TableColumn<Course, Double> colDuration=new TableColumn<Course,Double>();;

    private ObservableList<Course> courseList;

    @FXML
    private Button enrollButton;

    @FXML
    private Button withdrawButton;

    @FXML
    private void initialize() {

    	courseList = FXCollections.observableArrayList();
    	loadCourseData();

        
        
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        colCapacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colDeliveryMode.setCellValueFactory(new PropertyValueFactory<>("deliveryMode"));
        colDayOfLecture.setCellValueFactory(new PropertyValueFactory<>("dayOfLecture"));
        colTimeOfLecture.setCellValueFactory(new PropertyValueFactory<>("timeOfLecture"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        tableViewCourses.setItems(courseList);
//    	this.colCourseName.setVisible(false);
//    	this.colCapacity.setVisible(false);
//    	this.colYear.setVisible(false);
//    	this.colDeliveryMode.setVisible(false);
//    	this.colDayOfLecture.setVisible(false);
//    	this.colTimeOfLecture.setVisible(false);
//    	this.colDuration.setVisible(false);
            }

    private void loadCourseData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("course.csv"))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the first line (header)
                }
                
                String[] data = line.split(",", -1);
                if (data.length != 7) {
                    System.out.println("Invalid data: " + line);
                    continue;
                }
                
                String courseName = data[0].trim();
                int capacity;
                try {
                    capacity = Integer.parseInt(data[1].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid capacity: " + data[1]);
                    continue;
                }
                String year = data[2].trim();
                String deliveryMode = data[3].trim();
                String dayOfLecture = data[4].trim();
                String timeOfLecture = data[5].trim();
                double duration;
                try {
                    duration = Double.parseDouble(data[6].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid duration: " + data[6]);
                    continue;
                }

                Course course = new Course(courseName, capacity, year, deliveryMode, dayOfLecture,
                        timeOfLecture, duration);
                courseList.add(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void enrollCourse() {
        Course selectedCourse = tableViewCourses.getSelectionModel().getSelectedItem();
        System.out.println(selectedCourse);
        System.out.println(currentUser);
        if (selectedCourse != null && currentUser != null) {
            currentUser.enrolledCourses.add(selectedCourse);
            System.out.println("Enrolling in course: " + selectedCourse.getCourseName());
            // Add course details to user's text file
            String fileName = currentUser.getUsername() + ".txt";
            String directoryPath = "EnrolledStudents";
            Path filePath = Paths.get(directoryPath, fileName);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toString(), true))) {
                writer.write(selectedCourse.getCourseName() + "," +
                        selectedCourse.getCapacity() + "," +
                        selectedCourse.getYear() + "," +
                        selectedCourse.getDeliveryMode() + "," +
                        selectedCourse.getDayOfLecture() + "," +
                        selectedCourse.getTimeOfLecture() + "," +
                        selectedCourse.getDuration());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void withdrawCourse() {
        Course selectedCourse = tableViewCourses.getSelectionModel().getSelectedItem();
       
        if (selectedCourse != null && currentUser != null) {
            currentUser.enrolledCourses.remove(selectedCourse);
            System.out.println("Withdrawing from course: " + selectedCourse.getCourseName());
            // Remove course details from user's text file
            String fileName = currentUser.getUsername() + ".txt";
            String directoryPath = "EnrolledStudents";
            Path filePath = Paths.get(directoryPath, fileName);

            try {
                List<String> lines = Files.readAllLines(filePath);
                lines.removeIf(line -> line.contains(selectedCourse.getCourseName()));
                Files.write(filePath, lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
        	System.out.println("ERRor");
        }
    }
    
}
