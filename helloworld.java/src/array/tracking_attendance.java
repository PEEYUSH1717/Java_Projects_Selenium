package array;

import java.util.Scanner;
public class tracking_attendance {
		public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int[][] attendance = new int[2][7];

	        System.out.println("Enter attendance for 2 students (1 for Present, 0 for Absent):");

	        for (int i = 0; i < 2; i++) {
	            System.out.println("Student " + (i + 1) + ":");
	            for (int j = 0; j < 7; j++) {
	                System.out.print("  Day " + (j + 1) + ": ");
	                attendance[i][j] = sc.nextInt();
	            }}
	        System.out.println("\nAttendance Table (1 = Present, 0 = Absent):");
	        for (int i = 0; i < 2; i++) {
	            System.out.print("Student " + (i + 1) + ": ");
	            for (int j = 0; j < 7; j++) {
	                System.out.print(attendance[i][j] + " ");
	            }
	            System.out.println();
	        }

	        sc.close();
	    }}
