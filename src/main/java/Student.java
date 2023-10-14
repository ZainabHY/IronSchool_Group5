import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.UUID;

public class Student {
//    SchoolData schoolData = null;

    private static final AtomicInteger counter = new AtomicInteger(1);
    private String studentId;
    private String name;
    private String address;
    private String email;
    private Course course;

    public Student(String name, String address, String email) {
        this.studentId = generateStudentId();
        this.name = name;
        this.address = address;
        this.email = email;
        this.course = null;
    }

    private String generateStudentId() {
        Random random = new Random();
        int randomNumber = random.nextInt(10000); // Generate a random number between 0 and 9999
        return "stu" + String.format("%04d", randomNumber);
    }


    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Course getCourse() {
        return course;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}