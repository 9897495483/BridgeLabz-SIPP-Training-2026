// File Name: StreamingSubscriptionAnalyzer.java

// Superclass
class Subscription {

    String subscriberName;
    String subscriptionId;

    Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    // Method to calculate monthly charge
    double calculateMonthlyCharge() {
        return 0;
    }
}

// Basic Plan
class BasicPlan extends Subscription {

    BasicPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    double calculateMonthlyCharge() {
        return 199;
    }
}

// Premium Plan
class PremiumPlan extends Subscription {

    PremiumPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    double calculateMonthlyCharge() {
        return 499;
    }
}

// Family Plan
class FamilyPlan extends Subscription {

    FamilyPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    double calculateMonthlyCharge() {
        return 799;
    }
}

// Main Class
public class StreamingSubscriptionAnalyzer {

    // Search subscription by ID
    static void searchSubscription(Subscription[] subscriptions,
                                   String id) {

        boolean found = false;

        for (Subscription subscription : subscriptions) {

            if (subscription.subscriptionId.equals(id)) {

                System.out.println("\n===== Subscription Found =====");
                System.out.println("Subscriber Name : "
                        + subscription.subscriberName);
                System.out.println("Subscription ID : "
                        + subscription.subscriptionId);
                System.out.println("Monthly Charge  : ₹"
                        + subscription.calculateMonthlyCharge());

                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("\nSubscription Not Found.");
    }

    // Display subscribers whose names start with a letter
    static void displaySubscribersByLetter(
            Subscription[] subscriptions,
            char letter) {

        System.out.println("\n===== Subscribers Starting With '"
                + letter + "' =====");

        for (Subscription subscription : subscriptions) {

            if (subscription.subscriberName
                    .startsWith(String.valueOf(letter))) {

                System.out.println(subscription.subscriberName);
            }
        }
    }

    // Calculate total revenue
    static void calculateTotalRevenue(
            Subscription[] subscriptions) {

        double totalRevenue = 0;

        for (Subscription subscription : subscriptions) {
            totalRevenue += subscription.calculateMonthlyCharge();
        }

        System.out.println("\nTotal Monthly Revenue = ₹"
                + totalRevenue);
    }

    public static void main(String[] args) {

        Subscription[] subscriptions = {

                new BasicPlan("Rahul", "B101"),
                new PremiumPlan("Amit", "P201"),
                new FamilyPlan("Riya", "F301"),
                new PremiumPlan("Rohan", "P202"),
                new BasicPlan("Neha", "B102")
        };

        Subscription expensive = subscriptions[0];

        System.out.println("===== Subscription Details =====\n");

        // Dynamic Method Dispatch
        for (Subscription subscription : subscriptions) {

            System.out.println("Subscriber Name : "
                    + subscription.subscriberName);

            System.out.println("Subscription ID : "
                    + subscription.subscriptionId);

            System.out.println("Monthly Charge  : ₹"
                    + subscription.calculateMonthlyCharge());

            System.out.println("----------------------------");

            if (subscription.calculateMonthlyCharge()
                    > expensive.calculateMonthlyCharge()) {

                expensive = subscription;
            }
        }

        calculateTotalRevenue(subscriptions);

        searchSubscription(subscriptions, "P201");

        displaySubscribersByLetter(subscriptions, 'R');

        System.out.println("\n===== Most Expensive Subscription =====");
        System.out.println("Subscriber Name : "
                + expensive.subscriberName);

        System.out.println("Plan Charge     : ₹"
                + expensive.calculateMonthlyCharge());
    }
}