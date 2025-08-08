package wrapper_classes;

import java.util.HashMap;
import java.util.Scanner;

public class Scoreboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        HashMap<String, Integer> scoreboard = new HashMap<>();

        System.out.print("Enter number of students: ");
        String numInput = sc.nextLine(); 
        int n = Integer.parseInt(numInput); 
      
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter score for " + name + ": ");
            String scoreInput = sc.nextLine(); 
            int score = Integer.parseInt(scoreInput); 

            scoreboard.put(name, score); 
        }
        System.out.println("\nScoreboard");
        for (String student : scoreboard.keySet()) {
            int score = scoreboard.get(student); 
            System.out.println(student + " : " + score);
        }
    }
}
