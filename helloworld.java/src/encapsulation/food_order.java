package encapsulation;

public class food_order {
	
	    private int orderId;
	    private String foodItem;
	    private CustomerInfo customer;

	    public void setOrderDetails(int orderId, String foodItem) {
	        this.orderId = orderId;
	        this.foodItem = foodItem;
	    }

	    public void setCustomer(CustomerInfo customer) {
	        this.customer = customer;
	    }

	    public void getOrderDetails() {
	        System.out.println("Order ID: " + orderId);
	        System.out.println("Food Item: " + foodItem);
	        if (customer != null) {
	            customer.getCustomerName(); 
	        }
	    }
	}

	class CustomerInfo {
	    private String customerName;

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public void getCustomerName() {
	        System.out.println("Customer Name: " + customerName);
	    }
	}
