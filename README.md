**Brief Description**: This progict is about School Management System, that helps manage all of students, 
teachers and courses with some basic functionalities.


**The Structure of Project**
We have 6 Java classes, Repositories, and 5 Test classes .. let us describe them

**Java Classess**
1. Teacher class --> By Raghad Zedan
2. Student class --> By Manar Alriyami
3. Course class --> By All members
4. Commands --> By All members
   * Command class contains all the required commands (methods), plus **bouns** ones:
     **Required Commands**
     * ENROLL [STUDENT_ID] [COURSE_ID]
     * ASSIGN [TEACHER_ID] [COURSE_ID]
     * SHOW COURSES
     * LOOKUP COURSE [COURSE_ID]
     * SHOW STUDENTS
     * LOOKUP STUDENT [STUDENT_ID]
     * SHOW TEACHERS
     * LOOKUP TEACHER [TEACHER_ID]
     * SHOW PROFIT
       
     **Extra Commands**
     * SHOW STUDENTS [COURSE_ID]
     * SHOW MONEY EARNED
     * SHOW MONEY SPENT

5. SchoolData --> By Zainab AlYousef
   * SchoolData contains all methods used in main class, it's created to just arrange the flow of code
     * Methods of creation each of Teachers, Students, and Courses
     * Menues for each
     * List of IDs
   
7. StartIronSchool --> By Zainab AlYousef
   * This is the **main class** wich runs our School Management System

---------------
In addition, our project **handel errors** for all cases
Also **test cases** are included for main methods (most of the methods)
