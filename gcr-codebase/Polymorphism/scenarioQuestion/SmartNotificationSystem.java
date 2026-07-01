// File Name: SmartNotificationSystem.java

// Superclass
class Notification {

    String recipientName;
    String message;

    Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    void sendNotification() {
        System.out.println("Sending Notification...");
    }
}

// Email Notification
class EmailNotification extends Notification {

    EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    void sendNotification() {
        System.out.println("Email Notification");
        System.out.println("Recipient : " + recipientName);
        System.out.println("Message   : " + message);
        System.out.println("----------------------------");
    }
}

// SMS Notification
class SMSNotification extends Notification {

    SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    void sendNotification() {
        System.out.println("SMS Notification");
        System.out.println("Recipient : " + recipientName);
        System.out.println("Message   : " + message);
        System.out.println("----------------------------");
    }
}

// Push Notification
class PushNotification extends Notification {

    PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    void sendNotification() {
        System.out.println("Push Notification");
        System.out.println("Recipient : " + recipientName);
        System.out.println("Message   : " + message);
        System.out.println("----------------------------");
    }
}

// Main Class
public class SmartNotificationSystem {

    public static void main(String[] args) {

        // Dynamic Method Dispatch
        Notification[] notifications = {
                new EmailNotification("Rahul", "Meeting at 10 AM"),
                new SMSNotification("Amit", "Your OTP is 456789"),
                new PushNotification("Riya", "Your order has been delivered"),
                new EmailNotification("Neha", "Welcome to our company"),
                new PushNotification("Karan", "Flash Sale Starts Now!")
        };

        System.out.println("===== Sending Notifications =====\n");

        for (Notification n : notifications) {
            n.sendNotification();   // Dynamic Method Dispatch
        }

        System.out.println("All notifications sent successfully.");
    }
}