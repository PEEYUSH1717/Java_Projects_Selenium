package LambdaCalculator;

import java.util.Scanner;
interface Operation {
 double compute(double a, double b);
}

public class LambdaCalculator {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     System.out.print("Enter first number: ");
     double num1 = scanner.nextDouble();

     System.out.print("Enter second number: ");
     double num2 = scanner.nextDouble();

     System.out.print("Enter operation (+, -, *, /): ");
     String operator = scanner.next();

     Operation add = (a, b) -> a + b;
     Operation subtract = (a, b) -> a - b;
     Operation multiply = (a, b) -> a * b;
     Operation divide = (a, b) -> {
         if (b == 0) return 0;
         else return a / b;
     };

     double result = 0;

     if (operator.equals("+")) {
         result = add.compute(num1, num2);
         System.out.println("Addition: " + result);
     } else if (operator.equals("-")) {
         result = subtract.compute(num1, num2);
         System.out.println("Subtraction: " + result);
     } else if (operator.equals("*")) {
         result = multiply.compute(num1, num2);
         System.out.println("Multiplication: " + result);
     } else if (operator.equals("/")) {
         result = divide.compute(num1, num2);
         System.out.println("Division: " + result);
     } else {
         System.out.println("Invalid operator!");
     }

     scanner.close();
 }
}
