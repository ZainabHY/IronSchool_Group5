import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;;

class CommandsTest {
    SchoolData schoolData;

    Commands commands;
    Course course;



    @BeforeEach
    void setUp()
    {
        schoolData = new SchoolData();
        commands = new Commands();
    }

    @Test
    public void testLookUpExistingCourse() {
        // Create a course
        Course course = new Course("Java", 300.0);
        List<Course> courseList = new ArrayList<>();
        courseList.add(course);

        // Assign the coursesList to the coursesList in the schoolData object
        schoolData.coursesList = (ArrayList<Course>) courseList;

        // Call the lookUpCourse() method
        commands.lookUpCourse(course.getCourseId());

        // Get the course information from the schoolData object
        Course foundCourse = null;
        for (Course c : schoolData.coursesList) {
            if (c.getCourseId().equals(course.getCourseId())) {
                foundCourse = c;
                break;
            }
        }

        // Assert that the foundCourse is not null
        assertNotNull(foundCourse);

        // Assert that the foundCourse has the expected name
        assertEquals("Java", foundCourse.getName());

        // Assert that the foundCourse has the expected price
        assertEquals(300.0, foundCourse.getPrice(), 0.0);
    }

    @Test
    public void testLookUpNonExistingCourse() {
        // Create a list of courses
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Java", 300.0));

        // Assign the coursesList to the coursesList in the schoolData object
        schoolData.coursesList = (ArrayList<Course>) courseList;

        // Redirect standard output to capture the printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Call the lookUpCourse() method with a non-existing courseId
        commands.lookUpCourse("C002");

        // Restore standard output
        System.setOut(System.out);

        // Get the printed output
        String output = outputStream.toString();

        // Assert that the output contains the expected error message
        Assertions.assertTrue(output.contains("Course with ID C002 not found."));
    }
}