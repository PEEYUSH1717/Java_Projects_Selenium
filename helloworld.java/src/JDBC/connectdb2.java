package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class connectdb2 {
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

            String updateGohanSql = "UPDATE patient SET name = ? WHERE name = ?";
            PreparedStatement updateGohanStmt = con.prepareStatement(updateGohanSql);
            updateGohanStmt.setString(1, "Goten");
            updateGohanStmt.setString(2, "Gohan");

            int rowsAffected1 = updateGohanStmt.executeUpdate();
            if (rowsAffected1 > 0) {
                System.out.println("Name updated from Gohan to Goten successfully.");
            } else {
                System.out.println("No record found with name Gohan.");
            }

            String updatePicoloSql = "UPDATE patient SET name = ? WHERE name = ?";
            PreparedStatement updatePicoloStmt = con.prepareStatement(updatePicoloSql);
            updatePicoloStmt.setString(1, "Gojeta");
            updatePicoloStmt.setString(2, "Picolo");

            int rowsAffected2 = updatePicoloStmt.executeUpdate();
            if (rowsAffected2 > 0) {
                System.out.println("Name updated from Picolo to Gojeta successfully.");
            } else {
                System.out.println("No record found with name Picolo.");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
