import java.util.ArrayList;
import java.util.Scanner;

public class SchoolData {
    // This class holds methods for details for all of:
    // Teachers , Students , Courses

    public ArrayList<Teacher> teachersList = new ArrayList<>();
    public ArrayList<Course> coursesList =  new ArrayList<>();
    public ArrayList<Student> studentsList =  new ArrayList<>();

    Commands commands;

    Scanner scanner = new Scanner(System.in);

    // TEACHERS
    public void createTeachers()
    {
        Teacher teacher;
        System.out.println("\n\u001B[33mLet's begin by Teachers\u001B[0m");
        // Asking user to enter num of teachers
        System.out.println("How many teacher you want to create? ");
        int teacherNum = scanner.nextInt();
        scanner.nextLine();

        // Asking user to enter details of teachers
        System.out.println("Now please provide me with Teachers details");
        System.out.println("------------------------------------------");

        // for loop to take teachers info
        for (int i=0 ; i < teacherNum; i++)
        {
            System.out.println("Teacher #" + (i+1));

//            System.out.print("Teacher ID: ");
//            String teacherID = scanner.nextLine();

            System.out.print("Teacher Name: ");
            String teacherName = scanner.nextLine();

            System.out.print("Teacher Salary: ");
            double teacherSalary = scanner.nextDouble();
            scanner.nextLine();

            teacher = new Teacher(teacherName, teacherSalary);
            teachersList.add(teacher);

            System.out.println("--------------------\n");
        }
    }

    // COURSES
    public void createCourses()
    {
        Course course;

        System.out.println("\n\u001B[33mLet's move to courses.. \u001B[0m\n");

        // Asking user to enter num of courses
        System.out.println("How many courses you want to create? ");
        int courseNum = scanner.nextInt();
        scanner.nextLine();

        // Asking user to enter details of courses
        System.out.println("Now please provide me with Courses details");
        System.out.println("------------------------------------------");

        // for loop to take courses info
        for (int i=0 ; i < courseNum; i++)
        {
            System.out.println("Course #" + (i+1));

//            System.out.print("Course ID: ");
//            String courseID = scanner.nextLine();

            System.out.print("Course Name: ");
            String courseName = scanner.nextLine();

            System.out.print("Course Price: ");
            double coursePrice = scanner.nextDouble();
            scanner.nextLine();

//            System.out.print("Money Earned: ");
//            double moneyEarned = scanner.nextDouble();
//
//            System.out.print("Teacher: ");
//            Teacher teacher = scanner.nextLine();

            course = new Course(courseName, coursePrice);
            coursesList.add(course);

            System.out.println("--------------------\n");

        }
    }

    // STUDENTS
    public void createStudents()
    {
        Student student;

        System.out.println("\n\u001B[33mLet's move to Students..\u001B[0m \n");

        // Asking user to enter num of students
        System.out.println("How many students you want to create? ");
        int studentNum = scanner.nextInt();
        scanner.nextLine();

        // Asking user to enter details of students
        System.out.println("Now please provide me with Courses details");
        System.out.println("------------------------------------------");

        // for loop to take students info
        for (int i=0 ; i < studentNum; i++)
        {
            System.out.println("Student #" + (i+1));

//            System.out.print("Student ID: ");
//            String studentID = scanner.nextLine();

            System.out.print("Student Name: ");
            String studentName = scanner.nextLine();

            System.out.print("Student Address: ");
            String studentAddress = scanner.nextLine();

            System.out.print("Student Email: ");
            String studentEmail = scanner.nextLine();

//            System.out.print("Course: ");
//            Course course = scanner.nextLine();

            student = new Student(studentName, studentAddress, studentEmail);
            studentsList.add(student);

            System.out.println("--------------------\n");

        }
    }

    public void teachersMenu()
    {
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
                    System.out.println(">> To assign new teacher, you shall provide me with IDs of teacher and course");
                    teacherIds();
                    System.out.print("Teacher ID: ");
                    String teacherIdAssign = scanner.nextLine();

                    courseIds();
                    System.out.print("Course ID: ");
                    String courseIdAssign = scanner.nextLine();
                    commands.assignTeacher(teacherIdAssign, courseIdAssign);
                    break;

                case 2: commands.showTeachers();
                    break;

                case 3:
                    System.out.println(">> To look up a teacher, please provide me with the teacher's ID");
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
                    System.out.println(">> To enroll new student, please provide me with IDs of student and course");
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
                    System.out.println(">> To look up a student, please provide me with the student's ID");
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
                    System.out.println(">> To look up a course, please provide me with the course's ID");
                    courseIds();
                    System.out.print("Course ID: ");
                    String courseIdLookUp = scanner.nextLine();
                    commands.lookUpCourse(courseIdLookUp);
                    break;

                case 3:
                    System.out.println(">> To show student by course ID, please provide me with the course ID");
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
                case 1: commands.showProfit();
                    break;
                case 2: commands.showMoneyEarned();
                    break;
                case 3: commands.showMoneySpent();
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

}
