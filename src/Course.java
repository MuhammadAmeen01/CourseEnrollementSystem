//// This class represents a course offered by an educational institution
//public class Course {
//    // Private instance variables to store course details
//    private String name; // The name of the course
//    private int capacity; // The maximum number of students allowed in the course
//    private String year; // The academic year in which the course is offered
//    private String deliveryMode; // The mode of delivery (online, in-person, hybrid, etc.)
//    private String dayOfLecture; // The day(s) of the week on which the course is taught
//    private String timeOfLecture; // The time of day at which the course is taught
//    private double duration; // The duration of each lecture in hours
//    private int enrolledStudents; // The number of students currently enrolled in the course
//
//    // Constructor method to initialize the course details
//    public Course(String name, int capacity, String year, String deliveryMode, String dayOfLecture, String timeOfLecture, double duration) {
//        this.name = name;
//        this.capacity = capacity;
//        this.year = year;
//        this.deliveryMode = deliveryMode;
//        this.dayOfLecture = dayOfLecture;
//        this.timeOfLecture = timeOfLecture;
//        this.duration = duration;
//        this.enrolledStudents = 0; // Initialize the number of enrolled students to 0
//    }
//
//    // Getter methods to retrieve the course details
//    public String getName() {
//        return name;
//    }
//
//    public int getCapacity() {
//        return capacity;
//    }
//
//    public String getYear() {
//        return year;
//    }
//
//    public String getDeliveryMode() {
//        return deliveryMode;
//    }
//
//    public String getDayOfLecture() {
//        return dayOfLecture;
//    }
//
//    public String getTimeOfLecture() {
//        return timeOfLecture;
//    }
//
//    public double getDuration() {
//        return duration;
//    }
//
//    public int getEnrolledStudents() {
//        return enrolledStudents;
//    }
//
//    // Method to enroll a student in the course
//    public void enroll() {
//        enrolledStudents++;
//    }
//
//    // Method to withdraw a student from the course
//    public void withdraw() {
//        enrolledStudents--;
//    }
//
//    // Method to display the course details
//    public void display() {
//        System.out.println("Course name: " + name);
//        System.out.println("Capacity: " + capacity);
//        System.out.println("Year: " + year);
//        System.out.println("Delivery mode: " + deliveryMode);
//        System.out.println("Day of lecture: " + dayOfLecture);
//        System.out.println("Time of lecture: " + timeOfLecture);
//        System.out.println("Duration: " + duration);
//        System.out.println("Enrolled students: " + enrolledStudents);
//    }
//
//    // Method to check if there is still space available in the course
//    public boolean isAvailable() {
//        return enrolledStudents < capacity;
//    }
//}


public class Course {

    private String courseName;
    private int capacity;
    private String year;
    private String deliveryMode;
    private String dayOfLecture;
    private String timeOfLecture;
    private double duration;

    public Course(String courseName, int capacity, String year, String deliveryMode,
                  String dayOfLecture, String timeOfLecture, double duration) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.year = year;
        this.deliveryMode = deliveryMode;
        this.dayOfLecture = dayOfLecture;
        this.timeOfLecture = timeOfLecture;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getYear() {
        return year;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public String getDayOfLecture() {
        return dayOfLecture;
    }

    public String getTimeOfLecture() {
        return timeOfLecture;
    }

    public double getDuration() {
        return duration;
    }
}
