//import java.io.*;
//import java.util.*;
//import java.io.FileNotFoundException;
//
//public class ManagementSystem {
//    private List<Course> courses;
//
//    // Constructor with no arguments
//    public ManagementSystem() {
//        courses = new ArrayList<>();
//    }
//
//    // Constructor with courses argument
//    public ManagementSystem(List<Course> courses) {
//        this.courses = courses;
//    }
//
//    // Getter for courses list
//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    // Method to enroll a student in a course
//    public void enrollInCourse(String courseName) {
//        // Find the course in the list of courses
//        Course course = findCourseByName(courseName, courses);
//        if (course == null) {
//            System.out.println("Course not found: " + courseName);
//        } else if (!course.isAvailable()) {
//            System.out.println("Course is full: " + courseName);
//        } else {
//            // Enroll the student in the course
//            course.enroll();
//            System.out.println("Enrolled in course: " + courseName);
//        }
//    }
//
//    // Method to display all courses a student is enrolled in
//    public void displayEnrolledCourses() {
//        int i = 1;
//        for (Course course : courses) {
//            // Check if student is enrolled in the course
//            if (course.getEnrolledStudents() > 0) {
//                String timediff =  getEndTime(course.getTimeOfLecture() , course.getDuration());
//                // Print the course details
//                System.out.printf("%5d%s%-35s%-19s%-11s%s\n" , i , ")" , course.getName() , course.getDeliveryMode() , course.getDayOfLecture() , timediff);
//                i++;
//            }
//        }
//        // If no courses are enrolled, print message
//        if(i == 1){
//            System.out.println("No enrolled courses");
//        }
//    }
//
//    // Method to display all available courses
//    public void displayCourses() {
//        int i = 1;
//        for (Course course : courses) {
//            String timediff =  getEndTime(course.getTimeOfLecture() , course.getDuration());
//            // Print the course details
//            System.out.printf("%5d%s%-35s%-19s%-11s%s\n" , i , ")" , course.getName() , course.getDeliveryMode(),course.getDayOfLecture() ,timediff);
//            i++;
//        }
//    }
//
//    // Method to get a map of all courses a student is enrolled in
//    public Map<Integer,String> getEnrolledCourses() {
//        int i = 1;
//        Map<Integer,String> enrolledCourses = new HashMap<>();
//        for (Course course : courses) {
//            // Check if student is enrolled in the course
//            if (course.getEnrolledStudents() > 0) {
//                // Add the course to the map
//                enrolledCourses.put(i,course.getName());
//                i++;
//            }
//        }
//        // If no courses are enrolled, print message
//        if(i == 1){
//            System.out.println("No enrolled courses");
//        }
//        return enrolledCourses;
//    }
//
//    // Method to withdraw a student from a course
//    public void withdrawFromCourse(String courseName) {
//        // Find the course in the list of courses
//        Course course = findCourseByName(courseName, courses);
//        if (course == null) {
//            System.out.println("Course not found: " + courseName);
//        } else if (course.getEnrolledStudents() == 0) {
//            System.out.println("Not enrolled in course: " + courseName);
//        } else {
//            // Withdraw the student from the course
//            course.withdraw();
//            System.out.println("Withdrawn from course: " + courseName);
//        }
//    }
//
//    /**
//
//    Checks if there are any enrolled courses in the management system.
//    @return true if there is at least one enrolled course, false otherwise
//    */
//    public boolean hasEnrolledCourses() {
//        for(Course course : courses) {
//            if(course.getEnrolledStudents() > 0) {
//                return true;
//            }
//        }
//        return false;
//    }
//        /**
//        Finds a course in a given list of courses by name.
//        @param courseName the name of the course to find
//        @param courses the list of courses to search
//        @return the Course object with the given name, or null if not found
//        */
//
//        public static Course findCourseByName(String courseName, List<Course> courses) {
//            for (Course course : courses) {
//                if (course.getName().equalsIgnoreCase(courseName)) {
//                    return course;
//                }
//            }
//            return null;
//        }
//        /**
//        
//        Loads course data from a CSV file and adds the courses to the management system.
//        */
//        public void LoadCourses() {
//            try{
//                courses = new ArrayList<>();
//                File file = new File("course.csv");
//                Scanner scanner = new Scanner(file);
//                // Skip the header line
//                scanner.nextLine();
//                while (scanner.hasNextLine()) {
//                    String line = scanner.nextLine();
//                    String[] courseData = line.split(",");
//                    String courseName = courseData[0];
//                    int capacity = Integer.parseInt(courseData[1]);
//                    String year = courseData[2];
//                    String deliveryMode = courseData[3];
//                    String dayOfLecture = courseData[4];
//                    String timeOfLecture = courseData[5];
//                    double duration = Double.parseDouble(courseData[6]);
//                    Course course = new Course(courseName, capacity, year, deliveryMode, dayOfLecture, timeOfLecture, duration);
//                    courses.add(course);
//                }
//                scanner.close();
//            } catch (FileNotFoundException e) {
//                System.out.println("File not found");
//            }
//        }
//        /**
//        Saves course data to a CSV file with a given file name.
//        @param fileName the name of the CSV file to save to
//        */
//        public void saveCourses(String fileName) {
//            // Store the course details back to the CSV file
//            fileName = fileName + ".csv";
//            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
//                bw.write("Course Name,Capacity,Year,Delivery Mode,Day of Lecture,Time of Lecture,Duration,Enrolled Students");
//                bw.newLine();
//                for (Course course : courses) {
//                    bw.write(course.getName() + "," + course.getCapacity() + "," + course.getYear() + "," + course.getDeliveryMode()
//                    + "," + course.getDayOfLecture() + "," + course.getTimeOfLecture() + "," + course.getDuration()
//                    + "," + course.getEnrolledStudents());
//                    bw.newLine();
//                }
//            } catch (IOException e) {
//            e.printStackTrace();
//            }
//        }
//
//        public Map<Integer,String> matchingCourses(String keyword){
//            // Search for courses that match the keyword
//            List<Course> matchingCourses = searchCourses(keyword, courses);
//            if (matchingCourses.isEmpty()) {
//                System.out.println("No courses found matching the keyword '" + keyword + "'.");
//                return null;
//            }
//            // Create a map to store the user's selection of a course
//            Map<Integer,String> courseMap = new HashMap<>();
//            // Counter for the numbered list of matching courses
//            int i = 1;
//            System.out.println("\n----------------------------------------------------------------------------------------");
//            System.out.println("> Select From the List:");
//            System.out.println("----------------------------------------------------------------------------------------");
//            // Print out the matching courses in a numbered list
//            for (Course course : matchingCourses) {
//                // Get the end time of the course lecture
//                String timediff = getEndTime(course.getTimeOfLecture(), course.getDuration());
//                // Format and print the course information in a table-like format
//                System.out.printf("%5d%s%-35s%-19s%s\n" , i , ")" , course.getName() , course.getDeliveryMode() , course.getDayOfLecture());
//                // Add the course to the courseMap
//                courseMap.put(i,course.getName());
//                i++;
//            }
//            // Return the courseMap of matching courses
//            return courseMap;
//        }
//    
//    // Given the start time of a lecture and its duration, calculate the end time
//    public String getEndTime(String startTime, double duration) {
//        // Parse the start time string into hours and minutes
//        String[] parts = startTime.split(":");
//        int startHour = Integer.parseInt(parts[0]);
//        int startMinute = Integer.parseInt(parts[1]);
//    
//        // Calculate the end time in minutes since midnight
//        int endMinute = (int) ((startHour * 60 + startMinute) + duration * 60);
//    
//        // Convert the end time back to hours and minutes
//        int endHour = endMinute / 60;
//        int endMinuteOfHour = endMinute % 60;
//    
//        // Format the end time as a string in the same format as the start time
//        return String.format("%02d:%02d-%02d:%02d", startHour, startMinute, endHour, endMinuteOfHour);
//    }
//    
//    // Search for courses that match the keyword
//    private static List<Course> searchCourses(String keyword, List<Course> courses) {
//        // Create a list to store the matching courses
//        List<Course> matchingCourses = new ArrayList<>();
//        // Check each course for a match to the keyword
//        for (Course course : courses) {
//            if (course.getName().toLowerCase().contains(keyword) || course.getYear().toLowerCase().contains(keyword)
//                    || course.getDeliveryMode().toLowerCase().contains(keyword)) {
//                // Add the matching course to the list
//                matchingCourses.add(course);
//            }
//        }
//        // Return the list of matching courses
//        return matchingCourses;
//    }
//}    