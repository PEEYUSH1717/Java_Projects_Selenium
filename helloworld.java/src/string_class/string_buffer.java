package string_class;

public class string_buffer {
	    public static void main(String[] args) {
	        StringBuilder receipt = new StringBuilder();
	    
	        receipt.append("===== MARVEL STORE =====\n");
	        receipt.append("Date: 22-07-2025\n");
	        receipt.append("Cashier: Tom\n\n");
	 
	        receipt.append("Item           Qty   Price\n");
	        receipt.append("-----------------------------\n");
	        receipt.append("IRONMAN SET     1     ₹2000\n");
	        receipt.append("THOR SET        1     ₹2500\n");
	        receipt.append("HULK SET        1     ₹3000\n");

	        receipt.append("-----------------------------\n");
	        receipt.append("Total:              ₹7500\n");
	        receipt.append("Paid:               ₹8000\n");
	        receipt.append("Change:             ₹500\n");
	     
	        receipt.append("\nThank you for shopping!\n");
	        receipt.append("=========================");
	       
	        String finalReceipt = receipt.toString();
	        System.out.println(finalReceipt);
	    }}
