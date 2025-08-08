package array;

public class jagged_array {
	    public static void main(String[] args) {
	        int[][] projects = new int[3][];

	        projects[0] = new int[2]; 
	        projects[1] = new int[3];
	        projects[2] = new int[1]; 
	      
	        projects[0][0] = 5;
	        projects[0][1] = 6;

	        projects[1][0] = 4;
	        projects[1][1] = 7;
	        projects[1][2] = 3;

	        projects[2][0] = 8;
	       
	        System.out.println("Project hours of Employees:");
	        for (int i = 0; i < projects.length; i++) {
	            System.out.print("Employee " + (i + 1) + ": ");
	            for (int j = 0; j < projects[i].length; j++) {
	                System.out.print(projects[i][j] + " ");
	            }
	            System.out.println(); 
	        }}}


