import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseTest {
    SchoolData schoolData;
    Course course1;
    Course course2;


    @BeforeEach
    void setUp()
    {
        schoolData = new SchoolData();
        course1 = new Course("Java", 300.0);
        course2 = new Course("Science", 150.0);
        schoolData.coursesList.add(course1);
        schoolData.coursesList.add(course2);
    }


    @Test
    public void testGenerateCourseId() {
        String courseId1 = course1.getCourseId();
        String courseId2 = course2.getCourseId();

        Assertions.assertNotNull(courseId1);
        Assertions.assertNotNull(courseId2);
        Assertions.assertTrue(courseId1.startsWith("C"));
        Assertions.assertTrue(courseId2.startsWith("C"));
        Assertions.assertNotEquals(courseId1, courseId2);
    }

    @Test
    public void testFindCourseById() {
        Course foundCourse = course1.findCourseById(course1.getCourseId(), schoolData);

        Assertions.assertNotNull(foundCourse);
        Assertions.assertEquals(course1, foundCourse);
    }

    @Test
    public void testAssignTeacher() {
        Teacher teacher = new Teacher("Raneem Rashid", 10000.0);

        course1.assignTeacher(teacher);

        Assertions.assertEquals(teacher, course1.getTeacher());
    }
}