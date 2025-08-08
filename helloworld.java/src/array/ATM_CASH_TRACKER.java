package array;
import java.util.Scanner;
public class ATM_CASH_TRACKER {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        int[][] cash = new int[2][3];
	        
	        System.out.println("Enter number of notes in each ATM (₹100, ₹200, ₹500):");
	        for (int i = 0; i < 2; i++) {
	            System.out.println("ATM " + (i + 1) + ":");
	            for (int j = 0; j < 3; j++) {
	                if (j == 0) {
	                    System.out.print("  ₹100 notes: ");
	                } else if (j == 1) {
	                    System.out.print("  ₹200 notes: ");
	                } else {
	                    System.out.print("  ₹500 notes: ");
	                }
	                cash[i][j] = sc.nextInt();
	            }}
	        System.out.println("\nATM Cash Summary:");
	        for (int i = 0; i < 2; i++) {
	            System.out.println("ATM " + (i + 1) + ": ₹100 = " + cash[i][0] +
	                               ", ₹200 = " + cash[i][1] +
	                               ", ₹500 = " + cash[i][2]);
	        }

	        sc.close();
	    }
	}
