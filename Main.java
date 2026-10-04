package com.student;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static StudentDAO studentDAO = new StudentDAO();


    // ==========================================
    // MAIN METHOD
    // ==========================================

    public static void main(String[] args) {

        while (true) {

            showMenu();

            int choice = getIntegerInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    searchStudent();
                    break;

                case 6:

                    System.out.println();
                    System.out.println("Thank you for using");
                    System.out.println("Student Management System!");

                    scanner.close();

                    return;

                default:

                    System.out.println();
                    System.out.println(
                            "Invalid choice! Please select 1-6."
                    );
            }
        }
    }


    // ==========================================
    // MENU
    // ==========================================

    static void showMenu() {

        System.out.println();
        System.out.println(
                "=============================================="
        );

        System.out.println(
                "        STUDENT MANAGEMENT SYSTEM"
        );

        System.out.println(
                "=============================================="
        );

        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Search Student");
        System.out.println("6. Exit");

        System.out.println(
                "=============================================="
        );
    }


    // ==========================================
    // ADD STUDENT
    // ==========================================

    static void addStudent() {

        System.out.println();
        System.out.println("----------- ADD STUDENT -----------");

        String name;

        while (true) {

            System.out.print("Enter name: ");

            name = scanner.nextLine().trim();

            if (!name.isEmpty()) {
                break;
            }

            System.out.println("Name cannot be empty!");
        }


        int age;

        while (true) {

            age = getIntegerInput("Enter age: ");

            if (age > 0 && age < 100) {
                break;
            }

            System.out.println(
                    "Please enter a valid age!"
            );
        }


        String course;

        while (true) {

            System.out.print("Enter course: ");

            course = scanner.nextLine().trim();

            if (!course.isEmpty()) {
                break;
            }

            System.out.println("Course cannot be empty!");
        }


        String email;

        while (true) {

            System.out.print("Enter email: ");

            email = scanner.nextLine().trim();

            if (email.contains("@") && email.contains(".")) {
                break;
            }

            System.out.println(
                    "Please enter a valid email!"
            );
        }


        String phone;

        while (true) {

            System.out.print("Enter phone: ");

            phone = scanner.nextLine().trim();

            if (phone.matches("\\d{10}")) {
                break;
            }

            System.out.println(
                    "Phone number must contain 10 digits!"
            );
        }


        Student student = new Student(
                name,
                age,
                course,
                email,
                phone
        );


        studentDAO.addStudent(student);
    }


    // ==========================================
    // VIEW STUDENTS
    // ==========================================

    static void viewStudents() {

        System.out.println();
        System.out.println(
                "----------------------- STUDENT LIST -----------------------"
        );

        List<Student> students =
                studentDAO.getAllStudents();


        if (students.isEmpty()) {

            System.out.println(
                    "No students found."
            );

            return;
        }


        System.out.printf(
                "%-5s %-20s %-5s %-20s %-30s %-15s%n",
                "ID",
                "NAME",
                "AGE",
                "COURSE",
                "EMAIL",
                "PHONE"
        );


        System.out.println(
                "------------------------------------------------------------------------------------------------"
        );


        for (Student s : students) {

            System.out.printf(
                    "%-5d %-20s %-5d %-20s %-30s %-15s%n",

                    s.getId(),
                    s.getName(),
                    s.getAge(),
                    s.getCourse(),
                    s.getEmail(),
                    s.getPhone()
            );
        }


        System.out.println(
                "------------------------------------------------------------------------------------------------"
        );
    }


    // ==========================================
    // UPDATE STUDENT
    // ==========================================

    static void updateStudent() {

        System.out.println();
        System.out.println(
                "----------- UPDATE STUDENT -----------"
        );


        int id = getIntegerInput(
                "Enter student ID: "
        );


        Student existingStudent =
                studentDAO.getStudentById(id);


        if (existingStudent == null) {

            System.out.println(
                    "Student ID not found!"
            );

            return;
        }


        System.out.println(
                "Current student: " +
                        existingStudent
        );


        System.out.print(
                "Enter new name: "
        );

        String name =
                scanner.nextLine().trim();


        int age;

        while (true) {

            age = getIntegerInput(
                    "Enter new age: "
            );

            if (age > 0 && age < 100) {
                break;
            }

            System.out.println(
                    "Please enter a valid age!"
            );
        }


        System.out.print(
                "Enter new course: "
        );

        String course =
                scanner.nextLine().trim();


        String email;

        while (true) {

            System.out.print(
                    "Enter new email: "
            );

            email =
                    scanner.nextLine().trim();

            if (email.contains("@")
                    && email.contains(".")) {

                break;
            }

            System.out.println(
                    "Please enter a valid email!"
            );
        }


        String phone;

        while (true) {

            System.out.print(
                    "Enter new phone: "
            );

            phone =
                    scanner.nextLine().trim();

            if (phone.matches("\\d{10}")) {
                break;
            }

            System.out.println(
                    "Phone number must contain 10 digits!"
            );
        }


        Student student =
                new Student(
                        id,
                        name,
                        age,
                        course,
                        email,
                        phone
                );


        studentDAO.updateStudent(student);
    }


    // ==========================================
    // DELETE STUDENT
    // ==========================================

    static void deleteStudent() {

        System.out.println();
        System.out.println(
                "----------- DELETE STUDENT -----------"
        );


        int id = getIntegerInput(
                "Enter student ID: "
        );


        Student student =
                studentDAO.getStudentById(id);


        if (student == null) {

            System.out.println(
                    "Student ID not found!"
            );

            return;
        }


        System.out.println(
                "Student: " + student
        );


        System.out.print(
                "Are you sure you want to delete? (Y/N): "
        );

        String confirmation =
                scanner.nextLine().trim();


        if (confirmation.equalsIgnoreCase("Y")) {

            studentDAO.deleteStudent(id);

        } else {

            System.out.println(
                    "Delete operation cancelled."
            );
        }
    }


    // ==========================================
    // SEARCH STUDENT
    // ==========================================

    static void searchStudent() {

        System.out.println();
        System.out.println(
                "----------- SEARCH STUDENT -----------"
        );


        int id = getIntegerInput(
                "Enter student ID: "
        );


        Student student =
                studentDAO.getStudentById(id);


        if (student == null) {

            System.out.println(
                    "Student not found!"
            );

            return;
        }


        System.out.println();
        System.out.println(
                "Student Found!"
        );

        System.out.println(
                "--------------------------------"
        );

        System.out.println(
                "ID      : " + student.getId()
        );

        System.out.println(
                "Name    : " + student.getName()
        );

        System.out.println(
                "Age     : " + student.getAge()
        );

        System.out.println(
                "Course  : " + student.getCourse()
        );

        System.out.println(
                "Email   : " + student.getEmail()
        );

        System.out.println(
                "Phone   : " + student.getPhone()
        );

        System.out.println(
                "--------------------------------"
        );
    }


    // ==========================================
    // INTEGER INPUT VALIDATION
    // ==========================================

    static int getIntegerInput(String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number!"
                );
            }
        }
    }
}