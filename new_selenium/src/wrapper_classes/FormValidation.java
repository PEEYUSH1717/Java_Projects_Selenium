package wrapper_classes;

import java.util.Scanner;

public class FormValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();  

        System.out.print("Enter your age: ");
        String ageInput = sc.nextLine();

        try {
            int age = Integer.parseInt(ageInput); 
            if (age > 0) {
                System.out.println("\nForm Submitted Successfully!");
                System.out.println("Name: " + name);
                System.out.println("Age : " + age);
            } else {
                System.out.println("Invalid age. Age must be greater than 0.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid age format. Please enter a numeric value.");
        }}}
