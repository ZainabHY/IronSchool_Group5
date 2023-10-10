import java.util.Scanner;

public class StartIronSchool {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\u001B[34m>>>> Welcome to Iron School <<<<\u001B[0m");


        // Asking user to enter the school name
        System.out.print("\nPlease provide me with the name of the school: ");
        String schoolName = scanner.nextLine();

        SchoolData schoolData = new SchoolData();

    // TEACHERS -> Calling teachers method
        schoolData.createTeachers();

    // COURSES -> Calling courses method
        schoolData.createCourses();

    // STUDENTS -> Calling students method
        schoolData.createStudents();

    ////////

        System.out.println("-------------------------------");
    // Displaying Menu

        boolean exit = false;
        int choice;

        while (!exit)
        {
//            System.out.println(">> Please choose one of the commands to execute:");
            System.out.println("\u001B[33m>> Please choose one of the list to view its commands\u001B[0m");
            System.out.println("----------------------------------------------------");

            System.out.println("1. Teachers");
            System.out.println("2. Students");
            System.out.println("3. Courses");
            System.out.println("4. Financial Summary");
            System.out.println("5. Exit");

            System.out.print("\nYour  choice: ");

            // Taking user's choice
            while (true)
            {
                try{
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 1 || choice > 5)
                        throw new NumberFormatException();
                    break;
                }
                catch (NumberFormatException e)
                {
                    System.out.print("You should enter from 1 to 5. Please try again: ");
                }
            } // End of taking user's choice

            switch (choice)
            {
                case 1:
                    schoolData.teachersMenu();
                    break;
                case 2:
                    schoolData.studentsMenu();
                    break;
                case 3:
                    schoolData.coursesMenu();
                    break;
                case 4:
                    schoolData.financialSummary();
                    break;
                case 5:
                    exit = true;
                    System.out.println("\n\u001B[35mThank you for using the Iron School !\u001B[0m");
                    break;
            }
        }


    }
}
