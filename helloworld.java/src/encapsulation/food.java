package encapsulation;

public class food {
	    private int orderId;
	    private String customerName;
	    private String foodItem;

	    public void setOrderDetails(int orderId, String customerName, String foodItem) {
	        this.orderId = orderId;
	        this.customerName = customerName;
	        this.foodItem = foodItem;
	    }

	    public void getOrderDetails() {
	        System.out.println("Order ID: " + orderId);
	        System.out.println("Customer Name: " + customerName);
	        System.out.println("Food Item: " + foodItem);
	    }

	    public static void main(String[] args) {
	        food myOrder = new food();

	        myOrder.setOrderDetails(171, "Tom", "Pizza");

	        System.out.println("Your Order Details:");
	        myOrder.getOrderDetails();
	    }}
