package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class connectdb1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Hospital", 
                "root", 
                "thorTHUNDER$0707"
            );
            String insertSql = "INSERT INTO patient(name, age, disease) VALUES(?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insertSql);

            String[][] data = {
                {"Goku", "21", "Fever"},
                {"Vegeta", "21", "Cold"},
                {"Picolo", "21", "headche"},
                {"Gohan", "15", "Pain"}
            };

            for (String[] row : data) {
                pstmt.setString(1, row[0]);
                pstmt.setInt(2, Integer.parseInt(row[1]));
                pstmt.setString(3, row[2]);
                pstmt.executeUpdate();
            }

            System.out.println("All patients inserted successfully.");

            String updateSql = "UPDATE patient SET name = ? WHERE name = ?";
            PreparedStatement updateStmt = con.prepareStatement(updateSql);
            updateStmt.setString(1, "Goten");
            updateStmt.setString(2, "Gohan");

            int rowsAffected = updateStmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Name updated from Gohan to Goten successfully.");
            } else {
                System.out.println("No record found with name Gohan.");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}