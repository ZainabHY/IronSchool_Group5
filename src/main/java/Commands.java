
// This class holds all commands required + bonus commands
public class Commands {

    Teacher teacher = null;
    Course course = null;
    Student student = null;

    SchoolData schoolData = null;

    // ENROLL [STUDENT_ID] [COURSE_ID]
    public void enrollStudent(String studentId, String courseId)
    {
        Student findStudent = student.findStudentById(studentId, schoolData);
        Course findCourse = course.findCourseById(courseId, schoolData);

        if (findStudent == null) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }

        if (findCourse == null) {
            System.out.println("Course with ID " + courseId + " not found.");
            return;
        }

        if (findStudent.getCourse() != null) {
            System.out.println("Student " + findStudent.getName() + " is already enrolled in a course.");
            return;
        }

        findStudent.setCourse(findCourse);
        System.out.println("Course " + findCourse.getName() + " assigned to Student " + findStudent.getName());

        // Update Earned Money
        findCourse.setMoneyEarned((findCourse.getMoneyEarned())+ findCourse.getPrice());
    }

    // ASSIGN [TEACHER_ID] [COURSE_ID]
    public void assignTeacher(String teacherId, String courseId) {
        Teacher findTeacher = teacher.findTeacherById(teacherId , schoolData); // teacher.findTeacherById(teacherId)
        Course findCourse = course.findCourseById(courseId, schoolData); // course.findCourseById(courseId)

        if (findTeacher == null) {
            System.out.println("Teacher with ID " + teacherId + " not found.");
            return;
        }

        if (findCourse == null) {
            System.out.println("Course with ID " + courseId + " not found.");
            return;
        }

        findCourse.setTeacher(findTeacher);
        System.out.println("Teacher " + findTeacher.getName() + " assigned to Course " + findCourse.getName());
    }

    // SHOW COURSES
    public void showCourses()
    {
        for (int i=0 ; i < schoolData.coursesList.size(); i++)
        {
            System.out.println("Course #" + (i+1));

            System.out.print("Course ID: " + course.getCourseId());

            System.out.print("Course Name: " + course.getName());

            System.out.print("Course Price: " + course.getPrice());

            System.out.print("Money Earned: " + course.getMoneyEarned());

            System.out.print("Teacher: " + course.getTeacher());

            System.out.println("--------------------\n");
        }
    }

    // LOOKUP COURSE [COURSE_ID]
    public void lookUpCourse(String courseId)
    {
        if (course == null) {
            System.out.println("Course with ID " + courseId + " not found.");
            return;
        }
        for (Course course : schoolData.coursesList) {
            if (course.getCourseId().equals(courseId))
            {
                System.out.print("Course with ID: " + course.getCourseId());
                System.out.print("Course Name: " + course.getName());
                System.out.print("Course Price: " + course.getPrice());
                System.out.print("Money Earned: " + course.getMoneyEarned());
                System.out.print("Teacher: " + course.getTeacher());
            }
        }
    }

    // SHOW STUDENTS
    public void showStudents() {
        System.out.println("List of Students:");
        for (int i = 0; i < schoolData.studentsList.size(); i++) {
            Student student = schoolData.studentsList.get(i);
            System.out.println("Student #" + (i + 1));
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Address: " + student.getAddress());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Enrolled in Course: " + (student.getCourse() != null ? student.getCourse().getName() : "Not enrolled in any course"));
            System.out.println("--------------------\n");
        }
    }


    // LOOKUP STUDENT [STUDENT_ID]
    public void lookUpStudent(String studentId)
    {
        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }
        for (Student student : schoolData.studentsList) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Name: " + student.getName());
                System.out.println("Address: " + student.getAddress());
                System.out.println("Email: " + student.getEmail());
                System.out.println("Enrolled in Course: " + (student.getCourse() != null ? student.getCourse().getName() : "Not enrolled in any course"));
            }
        }
    }

    // SHOW TEACHERS
    public void showTeachers()
    {
        for (int i=0 ; i < schoolData.teachersList.size(); i++)
        {
            System.out.println("Teacher #" + (i+1));
            System.out.print("Teacher ID: " + schoolData.teachersList.get(i).getTeacherId());
            System.out.print("Teacher Name: " + schoolData.teachersList.get(i).getName());
            System.out.print("Teacher Salary: " + schoolData.teachersList.get(i).getSalary());

            System.out.println("--------------------\n");
        }
    }

    // LOOKUP TEACHER [TEACHER_ID]
    public void lookUpTeacher(String teacherId)
    {
        if (teacher == null) {
            System.out.println("Teacher with ID " + teacherId + " not found.");
            return;
        }
        for (Teacher teacher : schoolData.teachersList) {
            if (teacher.getTeacherId().equals(teacherId))
            {
                System.out.print("Teacher with ID: " + teacher.getTeacherId());
                System.out.print("Teacher Name: " + teacher.getName());
                System.out.print("Teacher Salary: " + teacher.getSalary());
            }

        }
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
        System.out.println("Students enrolled in Course with ID " + courseId + ":");
        boolean found = false;
        int count = 0 ;
        int num = 1;

        for (Student student : schoolData.studentsList) {
            if (student.getCourse().getCourseId().equals(courseId))
                count++;
        }

        System.out.println("Number of students enrolled: " + count);
        System.out.println("-----------------------------------\n");

        for (Student student : schoolData.studentsList) {
            if (student.getCourse().getCourseId().equals(courseId)) {
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

}