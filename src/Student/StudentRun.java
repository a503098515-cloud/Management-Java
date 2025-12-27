package Student;

import java.util.Scanner;


public class StudentRun {

static StudentManager manager = new StudentManager();//new manager opp
    static Scanner scanner = new Scanner(System.in);//give s manger to save data
public static void main(String[] args) {

System.out.println("--- Student Management System (Console) ---");
        System.out.println("Status: System Initialized.");

        // Loop for user input
        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            String input = scanner.next(); 
            int choice = -1;

            try {//if user enter letter throw Exception
                choice = Integer.parseInt(input); 
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                continue; // skip and try again
            }

            if (choice == 1) {
                addStudent(); // use the addStudents method
            } else if (choice == 2) {
            viewStudents();//use viewStudents method
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Error: Please enter option 1-3 only.");
            }
        }
        scanner.close();
    }

public static void addStudent() {//add student
       String name="";
        Long id=0L;
        double gpa=0.0;

        while (true) {// name need to  [a-zA-Z]
            System.out.print("Enter Name (Letters only): ");
            name = scanner.next();
            
            // Regex: [a-zA-Z]
            if (name.matches("[a-zA-Z]+")) {
                break; 
            } else {// loop
                System.out.println("Error: Name can only contain letters. Please try again.");
            }
        }

        while (true) {
            System.out.print("Enter 12-digit ID: ");
            String idInput = scanner.next(); 

            // if is 12 digits
            if (idInput.matches("\\d{12}")) {
                try {
                    id = Long.parseLong(idInput);//need to number 
                    break; 
                } catch (NumberFormatException e) {
                    System.out.println("Error: ID is too large or invalid.");//need 12 digits
                }
            } else {
                System.out.println("Error: ID must be exactly 12 digits. You entered " + idInput.length() + " digits.");
            }
        }

    while (true) {
            System.out.print("Enter GPA (0.0 - 4.0): ");//loop if gpa is 0.0-4.0
            String gpaInput = scanner.next(); 

            try {
                gpa = Double.parseDouble(gpaInput); 
                if (gpa >= 0.0 && gpa <= 4.0) {break; } 
                else {System.out.println("Error: GPA must be between 0.0 and 4.0.");}
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a number");
            }
        }

    manager.addStudent(name, id, gpa);//give the S Manager
        System.out.println("Success: Student added!");
}


public static void viewStudents() {// get student data
        System.out.println("\n--- Student List ---");
        if (manager.getAllStudents().isEmpty()) {//get for S Manager
            System.out.println("No students found.");
        } else {
            for (Student s : manager.getAllStudents()) {
                System.out.println("Name: " + s.getName() + " | ID: " + s.getId() + " | GPA: " + s.getGPA());
            }
        }
    }
}
