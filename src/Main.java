//
////import statements
//import java.io.IOException;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        // create an instance of the ManagementSystem class
//        ManagementSystem cms = new ManagementSystem();
//        // load the courses from the file
//        cms.LoadCourses();
//
//        // welcome message
//        System.out.println("\n\tWelcome to MyTimetable!");
//
//        // create a scanner object to read user input
//        try (Scanner scanner = new Scanner(System.in)) {
//            while (true) {
//                // display the main menu
//                System.out.println("\n----------------------------------------------------------------------------------------");
//                System.out.println("> Select from main menu");
//                System.out.println("----------------------------------------------------------------------------------------");
//                System.out.println("\t1. Enroll in course");
//                System.out.println("\t2. Withdraw from course");
//                System.out.println("\t3. Display enrolled courses");
//                System.out.println("\t4. Display all courses");
//                System.out.println("\t5. Save updated courses");
//                System.out.println("\t6. Exit");
//                System.out.print("Enter your choice: ");
//
//                // read user input
//                int choice = scanner.nextInt();
//                scanner.nextLine();
//                String courseName;
//
//                // process user choice
//                switch (choice) {
//                    case 1:
//                        // enroll in a course
//                        System.out.print("Please provide a Brand: ");
//                        String keyword = scanner.nextLine().toLowerCase();
//                        Map<Integer, String> match = cms.matchingCourses(keyword);
//                        if (match != null) {
//                            System.out.print("Select the course: ");
//                            try {
//                                int input = Integer.parseInt((scanner.nextLine()));
//                                if (input < 1 || input > match.size()) {
//                                    System.out.println("Invalid input");
//                                    break;
//                                }
//                                courseName = match.get(input);
//                                cms.enrollInCourse(courseName);
//                            } catch (NumberFormatException e) {
//                                System.out.println("Invalid input");
//                                break;
//                            }
//                        }
//                        break;
//                    case 2:
//                        // withdraw from a course
//                        if (!cms.hasEnrolledCourses()) {
//                            System.out.println("You have not enrolled in any courses");
//                        } else {
//                            System.out.println( "\n----------------------------------------------------------------------------------------");
//                            System.out.println("> Enrolled course(s):");
//                            System.out.println( "----------------------------------------------------------------------------------------");
//                            cms.displayEnrolledCourses();
//                            System.out.print("Select the course: ");
//                            int input = Integer.parseInt((scanner.nextLine()));
//                            Map<Integer, String> enrolled = cms.getEnrolledCourses();
//                            if (input < 1 || input > enrolled.size()) {
//                                System.out.println("Invalid input");
//                                break;
//                            }
//                            courseName = enrolled.get(input);
//                            cms.withdrawFromCourse(courseName);
//                        }
//                        break;
//                    case 3:
//                        // display enrolled courses
//                        if (!cms.hasEnrolledCourses()) {
//                            System.out.println("You have not enrolled in any courses");
//                            break;
//                        }
//                        System.out.println("\n----------------------------------------------------------------------------------------");
//                        System.out.println("> Enrolled course(s):");
//                        System.out.println("----------------------------------------------------------------------------------------");
//                        cms.displayEnrolledCourses();
//                        break;
//                    case 4:
//                        // display all courses
//                        System.out.println("\n----------------------------------------------------------------------------------------");
//                        System.out.println("> All course(s):");
//                        System.out.println("----------------------------------------------------------------------------------------");
//                        cms.displayCourses();
//                        break;
//                    case 5:
//                        // save the updated courses to a file
//                        cms.saveCourses("new_courses");
//                        System.out.println("Updated courses successfully saved to file 'new_courses.csv'");
//                        break;
//                    case 6:
//                        // exit the program
//                        System.out.println("exiting...");
//                        System.exit(0);
//                    default:
//                        // invalid input
//                        System.out.println("Invalid choice");
//                        break;
//                }
//            }
//
//        } catch (Exception e) { // Catch Statement
//            System.out.println("Error: " + e.getMessage()); // Prints the error message
//            System.out.println("exiting..."); // Prints the exit message
//            System.exit(1); // Exits the program
//        }
//
//    }
//}