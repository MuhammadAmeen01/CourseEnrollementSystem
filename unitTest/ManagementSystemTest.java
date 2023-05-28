//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.util.*;
//import static junit.framework.TestCase.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//public class ManagementSystemTest {
//    private ManagementSystem courseManager = new ManagementSystem();
//    private List<Course> courses;
//
//    @BeforeEach
//    public void setup() {
//        courses = new ArrayList<>();
//        courses.add(new Course("Java programming", 120, "Year 1", "Face-to-face", "Wednesday", "11:30", 2));
//        courses.add(new Course("Programming skills", 500, "Year 1", "Face-to-face", "Tuesday", "8:30", 1));
//        courses.add(new Course("Advanced Python programming", 40, "Year 2", "Face-to-face", "Friday", "16:00", 1.5));
//        courses.add(new Course("Math", 300, "Year 1", "Online", "Wednesday", "9:00", 2));
//        // courses.add(new Course("Data mining", 120, "Year 3","Online", "Thursday",
//        // "12:00", 2));
//        // courses.add(new Course("Knowledge technologies", 240, "Year
//        // 2","Face-to-face", "Friday", "14:00", 2));
//        // courses.add(new Course("Algorithms and complexity", 240,"Year 2",
//        // "Face-to-face", "Tuesday", "10:00", 1.5));
//        courseManager = new ManagementSystem(courses);
//    }
//
//    private String getDisplayOutput(ManagementSystem c) {
//        // This is a helper method that captures the output of the display method and returns it as a string.
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        return outContent.toString();
//    }
//
//    private String getDisplayOut(String c) {
//        // This is a helper method that captures the output of the display method and returns it as a string.
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        System.out.println(c);
//        return outContent.toString();
//    }
//
//    @Test
//    public void testEnrollInNonCourse() {
//        // Test enrolling in a non-existent course
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        courseManager.getEnrolledCourses();
//        Assertions.assertEquals("No enrolled courses\r\n", outContent.toString());
//    }
//
//    @Test
//    public void testEnrollInValidCourse() {
//        // Test enrolling in a valid course
//        courseManager.enrollInCourse("Math");
//        Assertions.assertEquals("Math", courseManager.getEnrolledCourses().get(1));
//    }
//
//    @Test
//    public void testEnrollInFullCourse() {
//        // Test enrolling in a full course
//        courseManager.enrollInCourse("Java programming");
//        courseManager.enrollInCourse("Math");
//        List<String> expected = Arrays.asList("Java programming", "Math");
//        List<String> actual = new ArrayList<>(courseManager.getEnrolledCourses().values());
//        System.out.println("test" + courseManager.getEnrolledCourses());
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testWithdrawFromCourse() {
//        // Test withdrawing from a course
//        Assertions.assertEquals(0, courseManager.getEnrolledCourses().size());
//        Assertions.assertEquals(0, courseManager.findCourseByName("Math", courses).getEnrolledStudents());
//        courseManager.enrollInCourse("Math");
//        Assertions.assertEquals(1, courseManager.getEnrolledCourses().size());
//        Assertions.assertEquals(1, courseManager.findCourseByName("Math", courses).getEnrolledStudents());
//
//        // Withdraw from course
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        courseManager.withdrawFromCourse("Math");
//        Assertions.assertEquals("Withdrawn from course: Math\r\n", outContent.toString());
//    }
//
//    @Test
//    public void testWithdrawFromNonexistentCourse() {
//        // Test withdrawing from a non-existent course
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        courseManager.withdrawFromCourse("Math");
//        Assertions.assertEquals("Not enrolled in course: Math\r\n", outContent.toString());
//    }
//
//    @Test
//    public void testDisplayEnrolledCourses() {
//        // Test displaying enrolled courses
//        courseManager.enrollInCourse("Java programming");
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        Assertions.assertDoesNotThrow(() -> courseManager.displayEnrolledCourses());
//        assertEquals("    1)Java programming                   Face-to-face       Wednesday  11:30-13:30\n",
//                outContent.toString());
//
//    }
//
//    @Test
//    public void testDisplayNoEnrolledCourses() {
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        // Test displaying no enrolled courses
//        Assertions.assertDoesNotThrow(() -> courseManager.displayEnrolledCourses());
//        Assertions.assertEquals("No enrolled courses\r\n", outContent.toString());
//    }
//
//    @Test
//    public void testDisplayCourses() {
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        // Test displaying all courses
//        Assertions.assertDoesNotThrow(() -> courseManager.displayCourses());
//        assertEquals("    1)Java programming                   Face-to-face       Wednesday  11:30-13:30\n" +
//                "    2)Programming skills                 Face-to-face       Tuesday    08:30-09:30\n" +
//                "    3)Advanced Python programming        Face-to-face       Friday     16:00-17:30\n" +
//                "    4)Math                               Online             Wednesday  09:00-11:00\n",
//                outContent.toString());
//    }
//
//    @Test
//    public void testHasEnrolledCourses() {
//        // Test hasEnrolledCourse
//        courseManager.enrollInCourse("Java programming");
//        Assertions.assertTrue(courseManager.hasEnrolledCourses());
//    }
//
//    @Test
//    public void testHasNoEnrolledCourses() {
//        // Test hasNoEnrolledCourse
//        Assertions.assertFalse(courseManager.hasEnrolledCourses());
//    }
//
//    @Test
//    public void testGetEndTime() {
//        // Test getEndTime method
//        String startTime = "09:00";
//        double duration = 1.5;
//        String expectedEndTime = "09:00-10:30";
//        String actualEndTime = courseManager.getEndTime(startTime, duration);
//        assertEquals(expectedEndTime, actualEndTime);
//    }
//
//    @Test
//    public void testLoadCourses() {
//        // Test loadCourses method
//        ManagementSystem expectedManager = new ManagementSystem();
//        List<Course> expectedCourses = new ArrayList<>();
//        expectedCourses.add(new Course("Java programming", 120, "Year 1", "Face-to-face", "Wednesday", "11:30", 2));
//        expectedCourses.add(new Course("Programming skills", 500, "Year 1", "Face-to-face", "Tuesday", "8:30", 1));
//        expectedCourses
//                .add(new Course("Advanced Python programming", 40, "Year 2", "Face-to-face", "Friday", "16:00", 1.5));
//        expectedCourses.add(new Course("Math", 300, "Year 1", "Online", "Wednesday", "9:00", 2));
//        expectedCourses.add(new Course("Data mining", 120, "Year 3", "Online", "Thursday", "12:00", 2));
//        expectedCourses.add(new Course("Knowledge technologies", 240, "Year 2", "Face-to-face", "Friday", "14:00", 2));
//        expectedCourses
//                .add(new Course("Algorithms and complexity", 240, "Year 2", "Face-to-face", "Tuesday", "10:00", 1.5));
//        expectedManager = new ManagementSystem(expectedCourses);
//
//        ManagementSystem actualManager = new ManagementSystem();
//        actualManager.LoadCourses();
//
//        List<Course> actualCourses = actualManager.getCourses();
//
//        assertEquals(expectedCourses.size(), actualCourses.size());
//
//        for (int i = 0; i < expectedCourses.size(); i++) {
//            Course expectedCourse = expectedCourses.get(i);
//            Course actualCourse = actualCourses.get(i);
//            assertEquals(expectedCourse.getName(), actualCourse.getName());
//            assertEquals(expectedCourse.getCapacity(), actualCourse.getCapacity());
//            assertEquals(expectedCourse.getYear(), actualCourse.getYear());
//            assertEquals(expectedCourse.getDeliveryMode(), actualCourse.getDeliveryMode());
//            assertEquals(expectedCourse.getDayOfLecture(), actualCourse.getDayOfLecture());
//            assertEquals(expectedCourse.getTimeOfLecture(), actualCourse.getTimeOfLecture());
//            assertEquals(expectedCourse.getDuration(), actualCourse.getDuration(), 0.001);
//        }
//    }
//
//    @Test
//    // Test getCourse method
//    public void testMatchingOneCourses() {
//        // Test with keyword that matches one course
//        Map<Integer, String> expected1 = new HashMap<>();
//        expected1.put(1, "Math");
//        Map<Integer, String> result1 = courseManager.matchingCourses("math");
//        assertEquals(expected1, result1);
//    }
//
//    @Test
//    // Test getCourse method
//    public void testMatchingMultipleCourses() {
//        // Test with keyword that matches multiple courses
//        Map<Integer, String> expected2 = new HashMap<>();
//        expected2.put(1, "Java programming");
//        expected2.put(2, "Programming skills");
//        expected2.put(3, "Advanced Python programming");
//        Map<Integer, String> result2 = courseManager.matchingCourses("program");
//        assertEquals(expected2, result2);
//    }
//
//    @Test
//    // Test getCourse method
//    public void testMatchingNoCourses() {
//        // Test with keyword that doesn't match any courses
//        Map<Integer, String> result3 = courseManager.matchingCourses("Basket Weaving");
//        assertNull(result3);
//    }
//}