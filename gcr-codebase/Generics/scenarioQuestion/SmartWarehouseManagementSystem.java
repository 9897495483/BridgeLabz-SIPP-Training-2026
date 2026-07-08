import java.util.ArrayList;
import java.util.List;

// Base Class
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void display();
}

// Electronics Class
class Electronics extends WarehouseItem {

    public Electronics(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Electronics : " + getName());
    }
}

// Groceries Class
class Groceries extends WarehouseItem {

    public Groceries(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Groceries : " + getName());
    }
}

// Furniture Class
class Furniture extends WarehouseItem {

    public Furniture(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Furniture : " + getName());
    }
}

// Generic Storage Class
class Storage<T extends WarehouseItem> {

    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void displayItems() {
        for (T item : items) {
            item.display();
        }
    }

    public List<T> getItems() {
        return items;
    }
}

// Utility Class
class WarehouseUtility {

    // Wildcard Method
    public static void displayAll(List<? extends WarehouseItem> items) {

        System.out.println("\nItems in Storage:");

        for (WarehouseItem item : items) {
            item.display();
        }
    }
}

// Main Class
public class SmartWarehouseManagementSystem {

    public static void main(String[] args) {

        // Electronics Storage
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));

        // Grocery Storage
        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Milk"));

        // Furniture Storage
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics Storage");
        electronicsStorage.displayItems();

        System.out.println("\nGrocery Storage");
        groceryStorage.displayItems();

        System.out.println("\nFurniture Storage");
        furnitureStorage.displayItems();

        // Wildcard Demonstration
        WarehouseUtility.displayAll(electronicsStorage.getItems());
        WarehouseUtility.displayAll(groceryStorage.getItems());
        WarehouseUtility.displayAll(furnitureStorage.getItems());
    }
}