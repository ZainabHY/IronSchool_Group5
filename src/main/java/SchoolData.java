import java.util.ArrayList;
import java.util.Scanner;

public class SchoolData {
    // This class holds methods for details for all of:
    // Teachers , Students , Courses

    public ArrayList<Teacher> teachersList;
    public ArrayList<Course> coursesList;
    public ArrayList<Student> studentsList;

    Commands commands;

    Scanner scanner = new Scanner(System.in);

    // TEACHERS
    public void createTeachers()
    {
        Teacher teacher;
        System.out.println("\u001B[33mLet's begin by Teachers\u001B[0m");
        // Asking user to enter num of teachers
        System.out.println("How many teacher you want to create? ");
        int teacherNum = scanner.nextInt();

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

            teacher = new Teacher(teacherName, teacherSalary);
            teachersList.add(teacher);

            System.out.println("--------------------\n");
        }
    }

    // COURSES
    public void createCourses()
    {
        Course course;

        System.out.println("\u001B[33mLet's move to courses.. \u001B[0m\n");

        // Asking user to enter num of courses
        System.out.println("How many courses you want to create? ");
        int courseNum = scanner.nextInt();

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

        System.out.println("\u001B[33mLet's move to Students..\u001B[0m \n");

        // Asking user to enter num of students
        System.out.println("How many students you want to create? ");
        int studentNum = scanner.nextInt();

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

            System.out.print("Course Price: ");
            Course course = scanner.nextLine();

            student = new Student(studentName, studentAddress, studentEmail);
            studentsList.add(course);

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
                case 1: commands.assignTeacher();
                    break;
                case 2: commands.showTeachers();
                    break;
                case 3: commands.lookUpTeacher();
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
                case 1: commands.enrollStudent();
                    break;
                case 2: commands.showStudents();
                    break;
                case 3: commands.lookUpStudent();
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
                case 1: showCourses();
                    break;
                case 2: lookUpCourse();
                    break;
                case 3: showStudentByCourseID();
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

}
