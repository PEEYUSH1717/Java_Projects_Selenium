package abstraction;

import java.util.Scanner;

abstract class NotificationService {
    abstract void send(String message);
}

class Email extends NotificationService {
    void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class Sms extends NotificationService {
    void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class Push extends NotificationService {
    void send(String message) {
        System.out.println("Push Notification: " + message);
    }
}

public class notification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter notification type (email/sms/push): ");
        String type = sc.nextLine();

        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        NotificationService n;

        if (type.equalsIgnoreCase("email")) {
            n = new Email();
        } else if (type.equalsIgnoreCase("sms")) {
            n = new Sms();
        } else {
            n = new Push();
        }

        n.send(msg);
        sc.close();
    }
}
