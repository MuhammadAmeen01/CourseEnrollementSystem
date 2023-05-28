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


public class Controller {
	public Stage appStage;
	public Scene scene;
	public Parent root;
    @FXML
    private TableView<Course> tableViewCourses;

    @FXML
    private TableColumn<Course, String> colCourseName;

    @FXML
    private TableColumn<Course, Integer> colCapacity;

    @FXML
    private TableColumn<Course, String> colYear;

    @FXML
    private TableColumn<Course, String> colDeliveryMode;

    @FXML
    private TableColumn<Course, String> colDayOfLecture;

    @FXML
    private TableColumn<Course, String> colTimeOfLecture;

    @FXML
    private TableColumn<Course, Double> colDuration;

    private ObservableList<Course> courseList;

    @FXML
    private Button enrollButton;

    @FXML
    private Button withdrawButton;

    @FXML
    private void initialize() {
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        colCapacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colDeliveryMode.setCellValueFactory(new PropertyValueFactory<>("deliveryMode"));
        colDayOfLecture.setCellValueFactory(new PropertyValueFactory<>("dayOfLecture"));
        colTimeOfLecture.setCellValueFactory(new PropertyValueFactory<>("timeOfLecture"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));

        courseList = FXCollections.observableArrayList();
        tableViewCourses.setItems(courseList);

        loadCourseData();
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
        if (selectedCourse != null) {
            System.out.println("Enrolling in course: " + selectedCourse.getCourseName());
        }
    }

    @FXML
    private void withdrawCourse() {
        Course selectedCourse = tableViewCourses.getSelectionModel().getSelectedItem();
        if (selectedCourse != null) {
            System.out.println("Withdrawing from course: " + selectedCourse.getCourseName());
        }
    }
}
