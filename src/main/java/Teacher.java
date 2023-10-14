
import java.util.Random;
import java.util.UUID;

public class Teacher {
//    SchoolData schoolData = null;

    private String TeacherId;

    private String name;

    private double salary;

    public Teacher(String name, double salary) {
        this.TeacherId = generateId();
        this.name = name;
        this.salary = salary;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private String generateId() {
        Random random = new Random();
        int randomNumber = random.nextInt(10000); // Generate a random number between 0 and 9999
        return 'T' + String.format("%04d", randomNumber);
    }

}