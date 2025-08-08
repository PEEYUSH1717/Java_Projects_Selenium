package wrapper_classes;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marksList = new ArrayList<>();

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            int mark = sc.nextInt();  
            marksList.add(mark);     
        }      
        int total = 0;
        for (Integer mark : marksList) {
            total += mark;
        }
        double average = (double) total / n;       
        System.out.println("\nMarks Entered: " + marksList);
        System.out.println("Total Marks  : " + total);
        System.out.println("Average Marks: " + average);
    }
}


