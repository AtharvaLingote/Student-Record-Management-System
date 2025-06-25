import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class StudentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadStudentsFromCSV();  // Load existing records

        int choice;
        do {
            System.out.println("\n🎓 Student Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: 
                    saveStudentsToCSV();  // Save before exiting
                    System.out.println("Exiting...");
                    break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student student = new Student(id, name, marks);
        studentList.add(student);
        System.out.println("✅ Student added successfully!");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("❌ No student records found.");
            return;
        }
        System.out.println("\n📋 All Student Records:");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        for (Student student : studentList) {
            if (student.getId() == id) {
                sc.nextLine(); // consume newline
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();

                student.setName(name);
                student.setMarks(marks);
                System.out.println("✅ Student updated successfully.");
                return;
            }
        }
        System.out.println("❌ Student with ID " + id + " not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        for (Student student : studentList) {
            if (student.getId() == id) {
                studentList.remove(student);
                System.out.println("✅ Student deleted successfully.");
                return;
            }
        }
        System.out.println("❌ Student with ID " + id + " not found.");
    }

    private static void loadStudentsFromCSV() {
        File file = new File("StudentRecord/students.csv");
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double marks = Double.parseDouble(parts[2].trim());
                    studentList.add(new Student(id, name, marks));
                }
            }
            System.out.println("📥 Loaded students from CSV.");
        } catch (IOException e) {
            System.out.println("⚠️ Error reading CSV: " + e.getMessage());
        }
    }

    private static void saveStudentsToCSV() {
        File file = new File("StudentRecord/students.csv");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Student student : studentList) {
                bw.write(student.getId() + "," + student.getName() + "," + student.getMarks());
                bw.newLine();
            }
            System.out.println("📤 Student data saved to CSV.");
        } catch (IOException e) {
            System.out.println("⚠️ Error writing CSV: " + e.getMessage());
        }
    }
}
