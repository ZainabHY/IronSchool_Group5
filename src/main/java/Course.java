import javax.swing.plaf.IconUIResource;
import java.util.Random;
import java.util.UUID;

public class Course {
//    SchoolData schoolData = null;

    private String courseId;
    private String name;
    private double price;
    private double moneyEarned;
    private Teacher teacher;

    public Course(String name, double price) {
        this.courseId = generateCourseID(); // Auto-Generate course Id
        this.name = name;
        this.price = price;
        this.moneyEarned = 0.0;
        this.teacher = null;
    }
    //--------\\

    // to Auto-Generate course Id \\
    private String generateCourseID(){
        Random random = new Random();
        int randomNumber = random.nextInt(10000); // Generate a random number between 0 and 9999
        return 'C' + String.format("%04d", randomNumber);

    }

    //--------\\

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    //--------\\

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    //--------\\


    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Course findCourseById(String courseId, SchoolData schoolData) {
        for (Course course : schoolData.coursesList) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
}
