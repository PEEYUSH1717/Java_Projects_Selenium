package JDBC;

import java.sql.*;
import java.util.Scanner;

public class connectdb3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Hospital", 
                "root", 
                "thorTHUNDER$0707"
            );

            String createTableSQL = "CREATE TABLE IF NOT EXISTS patient ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(100), "
                    + "age INT, "
                    + "disease VARCHAR(100), "
                    + "admission_date DATE, "
                    + "doctor_assigned VARCHAR(100))";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(createTableSQL);

          
            
            System.out.print("Enter number of patients to insert: ");
            int n = sc.nextInt();
            sc.nextLine(); 

            String insertSQL = "INSERT INTO patient (name, age, disease, admission_date, doctor_assigned) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insertSQL);

            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details for patient " + i);

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine(); 

                System.out.print("Disease: ");
                String disease = sc.nextLine();

                System.out.print("Admission Date (yyyy-mm-dd): ");
                String dateStr = sc.nextLine();
                Date admissionDate = Date.valueOf(dateStr);

                System.out.print("Doctor Assigned: ");
                String doctor = sc.nextLine();

                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, disease);
                pstmt.setDate(4, admissionDate);
                pstmt.setString(5, doctor);
                pstmt.executeUpdate();
            }

            System.out.println("\nAll patient details inserted successfully.\n");

            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
