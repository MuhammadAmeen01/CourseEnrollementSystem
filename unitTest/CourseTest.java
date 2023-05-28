//import org.junit.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import static org.junit.Assert.*;
//
//public class CourseTest {
//    // This method tests the enroll method of the Course class by checking if the number of enrolled students increases by 1 after the method is called.
//    @Test
//    public void testEnroll() {
//        Course c = new Course("Math", 30, "2022", "Online", "Monday", "9:00", 1.5);
//        int initialEnrolled = c.getEnrolledStudents();
//        c.enroll();
//        int newEnrolled = c.getEnrolledStudents();
//        assertEquals(initialEnrolled + 1, newEnrolled);
//    }
//    // This method tests the withdraw method of the Course class by checking if the number of enrolled students decreases by 1 after the method is called.
//    @Test
//    public void testWithdraw() {
//        Course c = new Course("Math", 30, "2022", "Online", "Monday", "9:00", 1.5);
//        c.enroll();
//        int initialEnrolled = c.getEnrolledStudents();
//        c.withdraw();
//        int newEnrolled = c.getEnrolledStudents();
//        assertEquals(initialEnrolled - 1, newEnrolled);
//    }
//
//    // This method tests the isAvailable method of the Course class by checking if the course is available for enrollment.
//    @Test
//    public void testIsAvailable() {
//        Course c = new Course("Math", 30, "2022", "Online", "Monday", "9:00", 1.5);
//        assertTrue(c.isAvailable());
//        for (int i = 0; i < 30; i++) {
//            c.enroll();
//        }
//        assertFalse(c.isAvailable());
//    }
//
//    // This method tests the display method of the Course class by checking if the output string matches the expected string.
//    @Test
//    public void testDisplay() {
//        Course c = new Course("Math", 30, "2022", "Online", "Monday", "9:00", 1.5);
//        String expected = "Course name: Math\r\nCapacity: 30\r\nYear: 2022\r\nDelivery mode: Online\r\nDay of lecture: Monday\r\nTime of lecture: 9:00\r\nDuration: 1.5\r\nEnrolled students: 0\r\n";
//        assertEquals(expected, getDisplayOutput(c));
//    }
//
//    // This is a helper method that captures the output of the display method and returns it as a string.
//    private String getDisplayOutput(Course c) {
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        c.display();
//        return outContent.toString();
//    }
//}