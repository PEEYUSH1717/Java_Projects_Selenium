package operator;

public class operator{
    public static void main(String[] args) {
        
        // Arithmetic Operators
        int a = 10;
        int b = 5;

        System.out.println("a + b = " + (a + b));  // Addition
        System.out.println("a - b = " + (a - b));  // Subtraction
        System.out.println("a * b = " + (a * b));  // Multiplication
        System.out.println("a / b = " + (a / b));  // Division
        System.out.println("a % b = " + (a % b));  // Modulus

        // Relational Operators
        System.out.println("a > b: " + (a > b));   // Greater than
        System.out.println("a < b: " + (a < b));   // Less than
        System.out.println("a == b: " + (a == b)); // Equal to
        System.out.println("a != b: " + (a != b)); // Not equal

        // Assignment Operators
        int num = 20;
        System.out.println("Original num = " + num);

        num += 5;  // num = num + 5
        System.out.println("After num += 5: " + num);

        num -= 2;  // num = num - 2
        System.out.println("After num -= 2: " + num);

        num *= 2;  // num = num * 2
        System.out.println("After num *= 2: " + num);

        num /= 3;  // num = num / 3
        System.out.println("After num /= 3: " + num);
    }
}