import java.util.List;
// This class holds all commands required + bonus commands
public class Commands {

    //    Teacher teacher;
//    Course course;
//    Student student;
    SchoolData schoolData;

    private List<Teacher> teachers;
    private List<Course> courses;
    private List<Student> students;

    public Commands(SchoolData schoolData)
    {
        this.schoolData = schoolData;
        this.teachers = schoolData.getTeachers();
        this.courses = schoolData.getCourses();
        this.students = schoolData.getStudents();
    }


    // ENROLL [STUDENT_ID] [COURSE_ID]
    public void enrollStudent(String studentId, String courseId)
    {
        Student findStudent = findStudentById(studentId);
        Course findCourse = findCourseById(courseId);

        if (findStudent == null) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }

        if (findCourse == null) {
            System.out.println("Course with ID " + courseId + " not found.");
            return;
        }

        if (findStudent.getCourse() != null) {
            System.out.println("\nStudent " + findStudent.getName() + " is already enrolled in a course.");
            return;
        }

        findStudent.setCourse(findCourse);
        System.out.println("\n\u001B[32mCourse " + findCourse.getName() + " assigned to Student " + findStudent.getName() +"\u001B[0m");

        // Update Earned Money
        findCourse.setMoneyEarned((findCourse.getMoneyEarned())+ findCourse.getPrice());
    }

    // ASSIGN [TEACHER_ID] [COURSE_ID]
    public void assignTeacher(String teacherId, String courseId) {
        Teacher findTeacher = findTeacherById(teacherId); // teacher.findTeacherById(teacherId)
        Course findCourse = findCourseById(courseId); // course.findCourseById(courseId)

        if (findTeacher == null) {
            System.out.println("Teacher with ID " + teacherId + " not found.");
            return;
        }

        if (findCourse == null) {
            System.out.println("Course with ID " + courseId + " not found.");
            return;
        }

        findCourse.setTeacher(findTeacher);
        System.out.println("\n\u001B[32mTeacher " + findTeacher.getName() + " assigned to Course " + findCourse.getName() + "\u001B[0m");
    }

    // SHOW COURSES
    public void showCourses()
    {
        System.out.println("\n\u001B[36mList of Courses:\u001B[0m");

        Course course;
        Teacher assignedTeacher;
        for (int i=0 ; i < schoolData.coursesList.size(); i++)
        {
            course = schoolData.coursesList.get(i);
            System.out.println("\u001B[32mCourse #" + (i+1) + "\u001B[0m");
            System.out.println("Course ID: " + course.getCourseId());
            System.out.println("Course Name: " + course.getName());
            System.out.println("Course Price: " + course.getPrice());
            System.out.println("Money Earned: " + course.getMoneyEarned());

            assignedTeacher = course.getTeacher();
            if (assignedTeacher != null) {
                System.out.println("Assigned Teacher: " + assignedTeacher.getName());
            } else {
                System.out.println("Assigned Teacher: No assigned teacher for this course");
            }

            System.out.println("--------------------\n");
        }
    }

    // LOOKUP COURSE [COURSE_ID]
    public void lookUpCourse(String courseId) {
        Course foundCourse = null;
        for (Course course : schoolData.getCourses()) {
            if (course.getCourseId().equals(courseId)) {
                foundCourse = course;
                break;
            }
        }

        if (foundCourse == null) {
            System.out.println("Course with ID " + courseId + " not found.");
            return;
        }


        System.out.println("\nCourse with ID: " + foundCourse.getCourseId());
        System.out.println("Course Name: " + foundCourse.getName());
        System.out.println("Course Price: " + foundCourse.getPrice());
        System.out.println("Money Earned: " + foundCourse.getMoneyEarned());

        Teacher assignedTeacher = foundCourse.getTeacher();
        if (assignedTeacher != null) {
            System.out.println("Assigned Teacher: " + assignedTeacher.getName());
        } else {
            System.out.println("Assigned Teacher: No assigned teacher for this course");
        }
    }

    // SHOW STUDENTS
    public void showStudents() {
        System.out.println("\n\u001B[36mList of Students:\u001B[0m");

        Student student;
        Course courseEnrolled;

        for (int i = 0; i < schoolData.studentsList.size(); i++) {
            student = schoolData.studentsList.get(i);
            System.out.println("\u001B[32mStudent #" + (i+1) + "\u001B[0m");

            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Address: " + student.getAddress());
            System.out.println("Email: " + student.getEmail());

            courseEnrolled = student.getCourse();
            if (courseEnrolled != null) {
                System.out.println("Enrolled in Course: " + courseEnrolled.getName());
            } else {
                System.out.println("Enrolled in Course: Not enrolled in any course");
            }

            System.out.println("--------------------\n");
        }
    }


    // LOOKUP STUDENT [STUDENT_ID]
    public void lookUpStudent(String studentId)
    {
        Student foundStudent = null;
        for(Student student : schoolData.getStudents())
        {
            if (student.getStudentId().equals(studentId))
            {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent == null) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }

        System.out.println("\nStudent ID: " + foundStudent.getStudentId());
        System.out.println("Name: " + foundStudent.getName());
        System.out.println("Address: " + foundStudent.getAddress());
        System.out.println("Email: " + foundStudent.getEmail());

        Course courseEnrolled = foundStudent.getCourse();
        if (courseEnrolled != null) {
            System.out.println("Enrolled in Course: " + courseEnrolled.getName());
        } else {
            System.out.println("Enrolled in Course: Not enrolled in any course");
        }
    }

    // SHOW TEACHERS
    public void showTeachers()
    {
        System.out.println("\n\u001B[36mList of Teachers:\u001B[0m");

        for (int i=0 ; i < schoolData.teachersList.size(); i++)
        {
            System.out.println("\u001B[32mTeacher #" + (i+1) + "\u001B[0m");

            System.out.println("Teacher ID: " + schoolData.teachersList.get(i).getTeacherId());
            System.out.println("Teacher Name: " + schoolData.teachersList.get(i).getName());
            System.out.println("Teacher Salary: " + schoolData.teachersList.get(i).getSalary());

            System.out.println("--------------------\n");
        }
    }

    // LOOKUP TEACHER [TEACHER_ID]
    public void lookUpTeacher(String teacherId)
    {
        Teacher foundTeacher = null;
        for(Teacher teacher : schoolData.getTeachers())
        {
            if (teacher.getTeacherId().equals(teacherId))
            {
                foundTeacher = teacher;
                break;
            }
        }

        if (foundTeacher == null) {
            System.out.println("Teacher with ID " + teacherId + " not found.");
            return;
        }

        System.out.println("\nTeacher with ID: " + foundTeacher.getTeacherId());
        System.out.println("Teacher Name: " + foundTeacher.getName());
        System.out.println("Teacher Salary: " + foundTeacher.getSalary());
    }

    // SHOW PROFIT
    public double showProfit(){
        return (showMoneyEarned() - showMoneySpent());
    }

//////////////////

// Bonus

    // SHOW STUDENTS [COURSE_ID]
    public void showStudentByCourseID(String courseId)
    {
        System.out.println("\nStudents enrolled in Course with ID " + courseId + ":");
        boolean found = false;
        int count = 0 ;
        int num = 1;
        Course stuCourse;
        for (Student student : schoolData.studentsList) {
            stuCourse = student.getCourse();
            if (stuCourse != null && stuCourse.getCourseId().equals(courseId))
                count++;
        }

        System.out.println("Number of students enrolled: " + count);
        System.out.println("-----------------------------------\n");

        for (Student student : schoolData.studentsList) {
            stuCourse = student.getCourse();
            if (stuCourse != null && stuCourse.getCourseId().equals(courseId)) {
                System.out.println("\u001B[32mStudent #" + (num++) + "\u001B[0m");
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Student Name: " + student.getName());
                System.out.println("Student Address: " + student.getAddress());
                System.out.println("Student Email: " + student.getEmail());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found for Course with ID " + courseId);
        }
    }

    // SHOW MONEY EARNED
    public double showMoneyEarned()
    {
        // Sum all earned money for each course

        double totalMoneyEarned = 0.0;
        for (Course course : schoolData.coursesList) {
            totalMoneyEarned += course.getMoneyEarned();
        }
        return totalMoneyEarned;

    }

    // SHOW MONEY SPENT
    public double showMoneySpent()
    {
        // Sum all teachers' salaries

        double totalMoneySpent = 0.0;
        for (Course course : schoolData.coursesList) {
            if (course.getTeacher() != null) {
                totalMoneySpent += course.getTeacher().getSalary();
            }
        }
        return totalMoneySpent;
    }

    // Helper methods to find students, teachers, and courses
    public Student findStudentById(String studentId) {
        for (Student student : schoolData.getStudents()) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null; // Return null if student is not found
    }

    public Teacher findTeacherById(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId().equals(teacherId)) {
                return teacher;
            }
        }
        return null; // Return null if teacher is not found
    }

    public Course findCourseById(String courseId) {
        for (Course course : schoolData.getCourses()) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null; // Return null if course is not found
    }

}
