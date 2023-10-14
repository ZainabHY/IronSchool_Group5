import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTest {
    SchoolData schoolData;

    Commands command;
    Student student1;
    Student student2;

    @BeforeEach
    void setUp()
    {
        schoolData = new SchoolData();
        command = new Commands(schoolData);

        student1 = new Student("Dana Sami", "Dammam", "dana.sami@gmail.com");
        student2 = new Student("Salem Fahad", "Khobar", "salem.fahad@gmail.com");
        schoolData.studentsList.add(student1);
        schoolData.studentsList.add(student2);
    }

    @Test
    public void testGenerateStudentId() {
        String studentId1 = student1.getStudentId();
        String studentId2 = student2.getStudentId();

        Assertions.assertNotNull(studentId1);
        Assertions.assertNotNull(studentId2);
        Assertions.assertTrue(studentId1.startsWith("stu"));
        Assertions.assertTrue(studentId2.startsWith("stu"));
        Assertions.assertNotEquals(studentId1, studentId2);
    }

    @Test
    public void testFindStudentById() {
        Student foundStudent = command.findStudentById(student1.getStudentId());

        Assertions.assertNotNull(foundStudent);
        Assertions.assertEquals(student1, foundStudent);
    }
}