import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;;

class CommandsTest {
    SchoolData schoolData;

    Commands commands;
    Student student1;
    Student student2;

    Teacher teacher1;
    Teacher teacher2;

    Course course1;
    Course course2;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUp()
    {
        schoolData = new SchoolData();
        commands = new Commands(schoolData);

        // Create Students
        student1 = new Student("Dana Sami", "Dammam", "dana.sami@gmail.com");
        student2 = new Student("Salem Fahad", "Khobar", "salem.fahad@gmail.com");
        schoolData.studentsList.add(student1);
        schoolData.studentsList.add(student2);

        // Create Teachers
        teacher1 = new Teacher("Raneem Rashid", 15000.0);
        teacher2 = new Teacher("Abdullah Khalid", 10000.0);
        schoolData.teachersList.add(teacher1);
        schoolData.teachersList.add(teacher2);


        // Create Courses
        course1 = new Course("Java", 300.0);
        course2 = new Course("Science", 150.0);
        schoolData.coursesList.add(course1);
        schoolData.coursesList.add(course2);


        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(outputStream));

    }



    // Test for enrolling student in a course successfully and in non existing course
    @Test
    public void testEnrollStudent() {
        // Test case 1: Enroll a student in a course successfully
        commands.enrollStudent(student1.getStudentId(), course2.getCourseId());
        Student enrolledStudent = commands.findStudentById(student1.getStudentId());
        Course enrolledCourse = commands.findCourseById(course2.getCourseId());
        assertNotNull(enrolledStudent.getCourse());
        assertEquals(enrolledCourse, enrolledStudent.getCourse());

        // Test case 2: Enroll a student in a non-existent course
        commands.enrollStudent(student2.getStudentId(), "nonExistent");
        Student student = commands.findStudentById(student2.getStudentId());
        assertNull(student.getCourse());
    }

    // Test for assigning Teacher for a course
    @Test
    public void testAssignTeacher() {
        // Assign a teacher to a course
        commands.assignTeacher(teacher1.getTeacherId(), course2.getCourseId());

        // Check that the teacher is  assigned to the course
        assertEquals(teacher1, course2.getTeacher());
    }


    // Test for showCourses method
    @Test
    public void testShowCourses() {
        // Call the showCourses() method
        commands.showCourses();

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        // To verify if teacher assigned to the course, if it's, return its name, otherwise a message is returned
        Teacher assignedTeacherC1 = course1.getTeacher();
        String msgC1 = "";
        Teacher assignedTeacherC2 = course2.getTeacher();
        String msgC2 = "";

        if (assignedTeacherC1 != null)
            msgC1 = assignedTeacherC1.getName();
        else
            msgC1 = "No assigned teacher for this course";

        if (assignedTeacherC2 != null)
            msgC2 = assignedTeacherC2.getName();
        else
            msgC2 = "No assigned teacher for this course";

        // Verify the printed output
        String expectedOutput= "\n\u001B[36mList of Courses:\u001B[0m\n" +
                "\u001B[32mCourse #1\u001B[0m\n" +
                "Course ID: " + course1.getCourseId() + "\n" +
                "Course Name: Java\n"+
                "Course Price: 300.0\n"+
                "Money Earned: 0.0\n"+
                "Assigned Teacher: No assigned teacher for this course\n"+
                "--------------------\n"+

                "\n\u001B[32mCourse #2\u001B[0m\n" +
                "Course ID: " + course2.getCourseId() + "\n" +
                "Course Name: Science\n"+
                "Course Price: 150.0\n" +
                "Money Earned: 0.0\n" +
                "Assigned Teacher: No assigned teacher for this course\n"+
                "--------------------\n\n";;

        assertEquals(expectedOutput, outputStream.toString(), "Output doesn't match the expected value.");
    }

    // Test LookUpCourse , 1st case: Existing
    @Test
    public void testLookUpExistingCourse() {
        List<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);

        // Assign the coursesList to the coursesList in the schoolData object
        schoolData.coursesList = (ArrayList<Course>) courseList;

        // Call the lookUpCourse() method
        commands.lookUpCourse(course1.getCourseId());

        // Get the course information from the schoolData object
        Course foundCourse = null;
        for (Course c : schoolData.coursesList) {
            if (c.getCourseId().equals(course1.getCourseId())) {
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

    // Test LookUpCourse , 2nd case: Not Existing
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

    // Test for showStudents method
    @Test
    public void testShowStudents() {
        // Call the showCourses() method
        commands.showStudents();

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        // To verify if course assigned to the student, if it's, return its name, otherwise a message is returned
        Course assignedCourseS1 = student1.getCourse();
        String msgS1 = "";
        Course assignedCourseS2 = student2.getCourse();
        String msgS2 = "";

        if (assignedCourseS1 != null)
            msgS1 = assignedCourseS1.getName();
        else
            msgS1 = "Not enrolled in any course";

        if (assignedCourseS2 != null)
            msgS2 = assignedCourseS2.getName();
        else
            msgS2 = "Not enrolled in any course";


        // Verify the printed output
        String expectedOutput= "\n\u001B[36mList of Students:\u001B[0m\n" +
                "\u001B[32mStudent #1\u001B[0m\n" +
                "Student ID: " + student1.getStudentId() + "\n" +
                "Name: Dana Sami\n"+
                "Address: Dammam\n"+
                "Email: dana.sami@gmail.com\n"+
                "Enrolled in Course: "+msgS1 +"\n"+
                "--------------------\n"+

                "\n\u001B[32mStudent #2\u001B[0m\n" +
                "Student ID: " + student2.getStudentId() + "\n" +
                "Name: Salem Fahad\n"+
                "Address: Khobar\n" +
                "Email: salem.fahad@gmail.com\n" +
                "Enrolled in Course: "+msgS2 +"\n"+
                "--------------------\n\n";;

        assertEquals(expectedOutput, outputStream.toString(), "Output doesn't match the expected value.");
    }

    // Test LookUpStudent
    @Test
    public void testLookUpStudent() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        // Assign the studentList to the studentsList in the schoolData object
        schoolData.studentsList = (ArrayList<Student>) studentList;

        // Call the lookUpStudent() method
        commands.lookUpStudent(student1.getStudentId());

        // Get the Student information from the schoolData object
        Student foundStudent = null;
        for (Student s : schoolData.studentsList) {
            if (s.getStudentId().equals(student1.getStudentId())) {
                foundStudent = s;
                break;
            }
        }

        // Assert that the foundStudent is not null
        assertNotNull(foundStudent);

        // Assert that the foundStudent has the expected name, address, email
        assertEquals("Dana Sami", foundStudent.getName());
        assertEquals("Dammam", foundStudent.getAddress());
        assertEquals("dana.sami@gmail.com", foundStudent.getEmail());

    }

    // Test for showTeachers method
    @Test
    public void testShowTeachers() {
        // Call the showCourses() method
        commands.showTeachers();

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);


        // Verify the printed output
        String expectedOutput= "\n\u001B[36mList of Teachers:\u001B[0m\n" +
                "\u001B[32mTeacher #1\u001B[0m\n" +
                "Teacher ID: " + teacher1.getTeacherId() + "\n" +
                "Teacher Name: Raneem Rashid\n"+
                "Teacher Salary: 15000.0\n"+
                "--------------------\n"+

                "\n\u001B[32mTeacher #2\u001B[0m\n" +
                "Teacher ID: " + teacher2.getTeacherId() + "\n" +
                "Teacher Name: Abdullah Khalid\n"+
                "Teacher Salary: 10000.0\n" +
                "--------------------\n\n";;

        assertEquals(expectedOutput, outputStream.toString(), "Output doesn't match the expected value.");
    }

    // Test LookUpTeacher
    @Test
    public void testLookUpTeacher() {
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher1);
        teacherList.add(teacher2);

        // Assign the teacherList to the teachersList in the schoolData object
        schoolData.teachersList = (ArrayList<Teacher>) teacherList;

        // Call the lookUpStudent() method
        commands.lookUpStudent(student1.getStudentId());

        // Get the Teacher information from the schoolData object
        Teacher foundTeacher = null;
        for (Teacher t : schoolData.teachersList) {
            if (t.getTeacherId().equals(teacher1.getTeacherId())) {
                foundTeacher = t;
                break;
            }
        }

        // Assert that the foundTeacher is not null
        assertNotNull(foundTeacher);

        // Assert that the foundTeacher has the expected name, salary
        assertEquals("Raneem Rashid", foundTeacher.getName());
        assertEquals(15000.0, foundTeacher.getSalary());

    }

    // Test for showMoneyEarned
    @Test
    public void testShowMoneyEarned() {
        // Create a test scenario with sample courses and their money earned
        course1.setMoneyEarned(18000.0); // Assuming there're 60 student enrolled in course 1
        course2.setMoneyEarned(10500.0); // Assuming there're 70 student enrolled in course 2

        // Money Earned is total money earned from all courses
        double expectedMoneyEarned = (18000.0 + 10500.0);
        double actualMoneyEarned = commands.showMoneyEarned();

        assertEquals(expectedMoneyEarned, actualMoneyEarned, 0.01);
    }

    // Test for showMoneySpent
    @Test
    public void testShowMoneySpent() {
        // Create a test scenario with sample courses and their assigned teachers and salaries
        course1.setTeacher(teacher1);
        course2.setTeacher(teacher2);

        // Money Spent total salaries of all teachers
        double expectedMoneySpent = (15000.0 + 10000.0);
        double actualMoneySpent = commands.showMoneySpent();

        assertEquals(expectedMoneySpent, actualMoneySpent, 0.01);
    }

    // Test for showProfit
    @Test
    public void testShowProfit() {
        // Create a test scenario with sample money earned and money spent
        course1.setMoneyEarned(18000.0); // Assuming there're 60 student enrolled in course 1
        course2.setMoneyEarned(10500.0); // Assuming there're 70 student enrolled in course 2

        course1.setTeacher(teacher1);
        course2.setTeacher(teacher2);

        // Profit is total money earned from all courses - total salaries of all teachers
        double expectedProfit = (18000.0 + 10500.0) - (15000.0 + 10000.0);
        double actualProfit = commands.showProfit();

        assertEquals(expectedProfit, actualProfit, 0.01);
    }
}