package new_program;

public class student{

    // This is a static variable. Same for all students.
    static String college = "ABC College";

    // This is an instance variable. Each student has a different roll number.
    int rollNo;

    // This method shows student info
    void showDetails() {
        // This is a local variable. Only used inside this method.
        String name = "Peeyush";

        // Print all the values
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNo);
        System.out.println("College: " + college);
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Create a student object
        Student s = new Student();

        // Set roll number
        s.rollNo = 101;

        // Show the student details
        s.showDetails();
    }
}