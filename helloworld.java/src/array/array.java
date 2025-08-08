package array;
import java.util.Scanner;
public class array {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int[][] arr = new int[2][2];

	    
	        System.out.println("Enter 4 numbers:");
	        arr[0][0] = sc.nextInt();
	        arr[0][1] = sc.nextInt();
	        arr[1][0] = sc.nextInt();
	        arr[1][1] = sc.nextInt();

	 
	        System.out.println("The 2D array is:");
	        System.out.print(arr[0][0] + " ");
	        System.out.println(arr[0][1]);
	        System.out.print(arr[1][0] + " ");
	        System.out.println(arr[1][1]);

	        sc.close();
	    }
	}
