package encapsulation;

	import java.util.Scanner;

	class Student {
	    private int studentId;
	    private String studentName;

	    public void setStudentDetails(int studentId, String studentName) {
	        this.studentId = studentId;
	        this.studentName = studentName;
	    }
	    public int getStudentId() {
	        return studentId;
	    }

	    public String getStudentName() {
	        return studentName;
	    }
	}
	class StudentInfo {
	    public void displayStudent(Student student) {
	        System.out.println("Student ID: " + student.getStudentId());
	        System.out.println("Student Name: " + student.getStudentName());
	    }
	}
	public class student {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        Student student = new Student();
	        System.out.print("Enter student ID: ");
	        int id = scanner.nextInt();
	        scanner.nextLine(); 

	        System.out.print("Enter student name: ");
	        String name = scanner.nextLine();

	        student.setStudentDetails(id, name);
	        StudentInfo studentInfo = new StudentInfo();
	        studentInfo.displayStudent(student); // display info

	        scanner.close();
	    }
	}
