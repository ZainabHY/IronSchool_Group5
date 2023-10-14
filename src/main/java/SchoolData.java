import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SchoolData {

    // This class holds methods for details for all of:
    // Teachers , Students , Courses

    public ArrayList<Teacher> teachersList = new ArrayList<>();
    public ArrayList<Course> coursesList =  new ArrayList<>();
    public ArrayList<Student> studentsList =  new ArrayList<>();

    private Commands commands;
    public void setCommands(Commands commands) {
        this.commands = commands;
    }

    Scanner scanner = new Scanner(System.in);

//    public SchoolData(Commands commands)
//    {
//        this.commands = commands;
//    }

    // TEACHERS
    public void createTeachers() {
        Teacher teacher;
        System.out.println("\n\u001B[33mLet's begin by Teachers\u001B[0m");

        // Asking user to enter num of teachers
        System.out.println("How many teachers do you want to create? ");
        int teacherNum;
        while (true) {
            try {
                teacherNum = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        // Asking user to enter details of teachers
        System.out.println("Now please provide me with Teachers' details");
        System.out.println("------------------------------------------");

        // for loop to take teachers' info
        for (int i = 0; i < teacherNum; i++) {
            System.out.println("Teacher #" + (i + 1));

            System.out.print("Teacher Name: ");
            String teacherName = scanner.nextLine();

            double teacherSalary;
            while (true) {
                try {
                    System.out.print("Teacher Salary: ");
                    teacherSalary = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid salary.");
                    scanner.nextLine(); // Clear the input buffer
                }
            }

            teacher = new Teacher(teacherName, teacherSalary);
            teachersList.add(teacher);

            System.out.println("--------------------\n");
        }
    }

    // COURSES
    public void createCourses() {
        Course course;

        System.out.println("\n\u001B[33mLet's move to courses.. \u001B[0m\n");

        // Asking user to enter num of courses
        System.out.println("How many courses do you want to create? ");
        int courseNum;
        while (true) {
            try {
                courseNum = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        // Asking user to enter details of courses
        System.out.println("Now please provide me with Courses' details");

        System.out.println("------------------------------------------");

        // for loop to take courses' info
        for (int i = 0; i < courseNum; i++) {
            System.out.println("Course #" + (i + 1));

            System.out.print("Course Name: ");
            String courseName = scanner.nextLine();

            double coursePrice;
            while (true) {
                try {
                    System.out.print("Course Price: ");
                    coursePrice = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid price.");
                    scanner.nextLine(); // Clear the input buffer
                }
            }

            course = new Course(courseName, coursePrice);
            coursesList.add(course);

            System.out.println("--------------------\n");
        }
    }

    // STUDENTS
    public void createStudents() {
        Student student;

        System.out.println("\n\u001B[33mLet's move to Students..\u001B[0m \n");

        // Asking user to enter num of students
        System.out.println("How many students do you want to create? ");
        int studentNum;
        while (true) {
            try {
                studentNum = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        // Asking user to enter details of students
        System.out.println("Now please provide me with Students' details");
        System.out.println("------------------------------------------");

        // for loop to take students' info
        for (int i = 0; i < studentNum; i++) {
            System.out.println("Student #" + (i + 1));

            System.out.print("Student Name: ");
            String studentName = scanner.nextLine();

            System.out.print("Student Address: ");
            String studentAddress = scanner.nextLine();

            System.out.print("Student Email: ");
            String studentEmail = scanner.nextLine();

            student = new Student(studentName, studentAddress, studentEmail);
            studentsList.add(student);

            System.out.println("--------------------\n");
        }
    }

    public void teachersMenu() {
        boolean returnToMainMenu = false;
        int choice;

        while (!returnToMainMenu) {
            System.out.println("\n\u001B[35mTeachers Menu\u001B[0m");

            System.out.println(">> Please choose one of the commands to execute:");
            System.out.println("------------------------------------------------");

            System.out.println("1. ASSIGN [TEACHER_ID] [COURSE_ID]");
            System.out.println("2. SHOW TEACHERS");
            System.out.println("3. LOOKUP TEACHER [TEACHER_ID]");
            System.out.println("4. Return to main menu");

            System.out.print("\nYour choice: ");

            // Taking user's choice
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 1 || choice > 4) {
                        throw new NumberFormatException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a number from 1 to 4: ");
                }
            } // End of taking user's choice

            switch (choice) {
                case 1:
                    System.out.println("\n\u001B[33m>> To assign a new teacher, you need to provide the IDs of the teacher and course\u001B[0m");

                    teacherIds();
                    System.out.print("Teacher ID: ");
                    String teacherIdAssign = scanner.nextLine();

                    courseIds();
                    System.out.print("Course ID: ");
                    String courseIdAssign = scanner.nextLine();
                    commands.assignTeacher(teacherIdAssign, courseIdAssign);
                    break;

                case 2:
                    commands.showTeachers();
                    break;

                case 3:
                    System.out.println("\n\u001B[33m>> To look up a teacher, please provide the teacher's ID\u001B[0m");
                    teacherIds();
                    System.out.print("Teacher ID: ");
                    String teacherIdLookUp = scanner.nextLine();
                    commands.lookUpTeacher(teacherIdLookUp);
                    break;

                case 4:
                    returnToMainMenu = true;
                    break;
            }
        }

        System.out.println("\n\u001B[33mReturning to the main menu...\u001B[0m");
    }
    public void studentsMenu()
    {
        boolean returnToMainMenu = false;
        int choice;

        while (!returnToMainMenu) {
            System.out.println("\n\u001B[35mStudents Menu\u001B[0m");
            System.out.println(">> Please choose one of the commands to execute:");
            System.out.println("------------------------------------------------");

            System.out.println("1. ENROLL [STUDENT_ID] [COURSE_ID]:");
            System.out.println("2. SHOW STUDENTS");
            System.out.println("3. LOOKUP STUDENT [STUDENT_ID]");
            System.out.println("4. Return to main menu");

            System.out.print("\nYour  choice: ");

            // Taking user's choice
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 1 || choice > 4)
                        throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("You should enter from 1 to 4. Please try again: ");
                }
            } // End of taking user's choice

            switch (choice)
            {
                case 1:
                    System.out.println("\n\u001B[33m>> To enroll new student, please provide me with IDs of student and course\u001B[0m");

                    studentIds();
                    System.out.print("Student ID: ");
                    String studentIdEnroll = scanner.nextLine();

                    courseIds();
                    System.out.print("Course ID: ");
                    String courseIdEnroll = scanner.nextLine();
                    commands.enrollStudent(studentIdEnroll, courseIdEnroll);
                    break;

                case 2: commands.showStudents();
                    break;

                case 3:
                    System.out.println("\n\u001B[33m>> To look up a student, please provide me with the student's ID\u001B[0m");
                    studentIds();
                    System.out.print("Student ID: ");
                    String studentIdLookUp = scanner.nextLine();
                    commands.lookUpStudent(studentIdLookUp);
                    break;
                case 4:
                    returnToMainMenu = true;
                    break;
            }
        }

        System.out.println("\n\u001B[33mReturning to the main menu...\u001B[0m");
    }
    public void coursesMenu()
    {
        boolean returnToMainMenu = false;
        int choice;

        while (!returnToMainMenu) {
            System.out.println("\n\u001B[35mCourses Menu\u001B[0m");
            System.out.println(">> Please choose one of the commands to execute:");
            System.out.println("------------------------------------------------");

            System.out.println("1. SHOW COURSES");
            System.out.println("2. LOOKUP COURSE [COURSE_ID]");
            System.out.println("3. SHOW STUDENTS [COURSE_ID]");
            System.out.println("4. Return to main menu");

            System.out.print("\nYour  choice: ");

            // Taking user's choice
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 1 || choice > 4)
                        throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("You should enter from 1 to 4. Please try again: ");
                }
            } // End of taking user's choice

            switch (choice)
            {
                case 1: commands.showCourses();
                    break;

                case 2:
                    System.out.println("\n\u001B[33m>> To look up a course, please provide me with the course's ID\u001B[0m");

                    courseIds();
                    System.out.print("Course ID: ");
                    String courseIdLookUp = scanner.nextLine();
                    commands.lookUpCourse(courseIdLookUp);
                    break;

                case 3:
                    System.out.println("\n\u001B[33m>> To show student by course ID, please provide me with the course ID\u001B[0m");

                    courseIds();
                    System.out.print("Course ID: ");
                    String studentShow_byCourseID = scanner.nextLine();
                    commands.showStudentByCourseID(studentShow_byCourseID);
                    break;

                case 4:
                    returnToMainMenu = true;
                    break;
            }
        }

        System.out.println("\n\u001B[33mReturning to the main menu...\u001B[0m");
    }

    public void financialSummary()
    {
        boolean returnToMainMenu = false;
        int choice;

        while (!returnToMainMenu) {
            System.out.println("\n\u001B[35mFinancial Summary\u001B[0m");
            System.out.println(">> Please choose one of the commands to execute:");
            System.out.println("------------------------------------------------");
// CHECK This
            System.out.println("1. SHOW PROFIT");
            System.out.println("2. SHOW MONEY EARNED");
            System.out.println("3. SHOW MONEY SPENT");
            System.out.println("4. Return to main menu");

            System.out.print("\nYour  choice: ");

            // Taking user's choice
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 1 || choice > 4)
                        throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("You should enter from 1 to 4. Please try again: ");
                }
            } // End of taking user's choice

            switch (choice)
            {
                case 1:
                    System.out.print("\n\u001B[36mProfit gained from Iron School is: \u001B[0m");
                    System.out.print(commands.showProfit());
                    System.out.println();
                    break;

                case 2: System.out.print("\n\u001B[36mMoney earned from Iron School is: \u001B[0m");
                    System.out.print(commands.showMoneyEarned());
                    System.out.println();
                    break;

                case 3: System.out.print("\n\u001B[36mMoney spent in Iron School is:\u001B[0m ");
                    System.out.print(commands.showMoneySpent());
                    System.out.println();
                    break;
                case 4:
                    returnToMainMenu = true;
                    break;
            }
        }

        System.out.println("\n\u001B[33mReturning to the main menu...\u001B[0m");
    }



    // List of Teachers ids
    public void teacherIds()
    {
        System.out.println("\u001B[35mTeachers IDs List\u001B[0m");
        System.out.println("----------------");

        for (int i = 0; i < teachersList.size(); i++)
        {
            System.out.println((i+1) + ". Teacher ID: " + teachersList.get(i).getTeacherId() +
                    " | Teacher Name: " + teachersList.get(i).getName());
        }
    }

    // List of Courses ids
    public void courseIds()
    {
        System.out.println("\u001B[35m\nCourses IDs List\u001B[0m");
        System.out.println("----------------");

        for (int i = 0; i < coursesList.size(); i++)
        {
            System.out.println((i+1) + ". Course ID: " + coursesList.get(i).getCourseId() +
                    " | Course Name: " + coursesList.get(i).getName());
        }
    }

    // List of Students ids
    public void studentIds()
    {
        System.out.println("\u001B[35m\nStudents IDs List\u001B[0m");
        System.out.println("----------------");

        for (int i = 0; i < studentsList.size(); i++)
        {
            System.out.println((i+1) + ". Student ID: " + studentsList.get(i).getStudentId() +
                    " | Student Name: " + studentsList.get(i).getName());
        }
    }

    public List<Teacher> getTeachers() {
        return teachersList;
    }
    public List<Student> getStudents() {
        return studentsList;
    }
    public List<Course> getCourses() {
        return coursesList;
    }
}
