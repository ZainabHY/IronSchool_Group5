import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeacherTest {

    SchoolData schoolData;
    Teacher teacher1;
    Teacher teacher2;


    @BeforeEach
    void setUp()
    {
        schoolData = new SchoolData();
        teacher1 = new Teacher("Raneem Rashid", 15000.0);
        teacher2 = new Teacher("Abdullah Khalid", 10000.0);


        schoolData.teachersList.add(teacher1);
        schoolData.teachersList.add(teacher2);
    }

    @Test
    public void testGenerateId() {
        String teacherId = teacher1.getTeacherId();

        Assertions.assertNotNull(teacherId);
        Assertions.assertTrue(teacherId.startsWith("T"));
        Assertions.assertEquals(4, teacherId.length() - 1); // Length should be 4 (T + 3 digits)
    }

    @Test
    public void testFindTeacherById() {
        Teacher foundTeacher = teacher2.findTeacherById(teacher2.getTeacherId(), schoolData);

        Assertions.assertNotNull(foundTeacher);
        Assertions.assertEquals(teacher2, foundTeacher);
    }
}