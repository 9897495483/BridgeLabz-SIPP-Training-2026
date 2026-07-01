interface FoodDelivery {

    void deliverFood();

    default void trackOrder() {
        System.out.println("Food Order Tracking...");
    }

    static int generateDeliveryCode() {
        return (int)(Math.random() * 10000);
    }
}

interface GroceryDelivery {

    void deliverGroceries();

    default void trackOrder() {
        System.out.println("Grocery Order Tracking...");
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {

    public void deliverFood() {
        System.out.println("Food Delivered");
    }

    public void deliverGroceries() {
        System.out.println("Groceries Delivered");
    }

    @Override
    public void trackOrder() {
        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
    }
}

public class foodGroceryDelivery {

    public static void main(String[] args) {

        String customers[] = {
                "Rahul",
                "Anjali",
                "Vikas"
        };

        DeliveryExecutive d = new DeliveryExecutive();

        for (String customer : customers) {

            System.out.println("\nCustomer : " + customer);

            d.trackOrder();

            d.deliverFood();

            d.deliverGroceries();

            System.out.println("Delivery Code : "
                    + FoodDelivery.generateDeliveryCode());
        }
    }
}