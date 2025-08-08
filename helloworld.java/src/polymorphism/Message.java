package polymorphism;

	import java.util.Scanner;
	class MessageSender {
	    void sendMessage() {
	        System.out.println("Sending a generic message.");
	    }
	}
	class Email extends MessageSender {
	    void sendMessage() {
	        System.out.println("Sending Email message.");
	    }
	}
	class Sms extends MessageSender {
	    void sendMessage() {
	        System.out.println("Sending SMS message.");
	    }
	}
	public class Message {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Choose message type (Email/SMS): ");
	        String type = scanner.nextLine();
	        MessageSender messageSender;
	        if (type.equalsIgnoreCase("Email")) {
	            messageSender = new Email();
	        } else {
	            messageSender = new Sms();
	        }
	        messageSender.sendMessage();

	        scanner.close();
	    }
	}
