package string_class;

public class string_buffer1 {
	    public static void main(String[] args) {
	
	        StringBuilder report = new StringBuilder();
	      
	        report.append("======= Employee Profile Report =======\n");
	        report.append("Employee ID   : EMP3000\n");
	        report.append("Name          : IRON MAN\n");
	        report.append("Department    : MARVEL STUDIO\n");
	        report.append("Designation   : Engineer\n");
	        report.append("Email         : ironman3000gmail.com\n");
	        report.append("Phone         : 3000030000\n");
	        report.append("---------------------------------------\n");
	      
	        report.append("Date of Joining : 10-Mar-2010\n");
	        report.append("Experience      : 20Years\n");
	        report.append("Current Project : NANO PARTICLES ARMOURED SUIT\n");
	 
	        report.append("\nReport Generated Successfully!\n");
	        report.append("=======================================");
	       
	        String finalReport = report.toString();
	        System.out.println(finalReport);
	    }
	}
