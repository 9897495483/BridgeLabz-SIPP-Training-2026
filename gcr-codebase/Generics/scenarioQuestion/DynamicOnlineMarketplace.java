import java.util.ArrayList;
import java.util.List;

// Base Category
abstract class ProductCategory {
    private String categoryName;

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

// Categories
class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadgets");
    }
}

// Generic Product Class
class Product<T extends ProductCategory> {
    private String productName;
    private double price;
    private T category;

    public Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product : " + productName +
                "\nCategory : " + category.getCategoryName() +
                "\nPrice : ₹" + price + "\n";
    }
}

// Utility Class
class MarketplaceUtility {

    // Generic Method
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {

        double discount = product.getPrice() * percentage / 100;
        product.setPrice(product.getPrice() - discount);

        System.out.println(
                percentage + "% Discount Applied on " +
                product.getProductName());
    }

    // Wildcard Method
    public static void displayCatalog(List<? extends Product<?>> products) {

        System.out.println("\n------ Product Catalog ------");

        for (Product<?> product : products) {
            System.out.println(product);
        }
    }
}

// Main Class
public class DynamicOnlineMarketplace {

    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Programming", 750,
                        new BookCategory());

        Product<ClothingCategory> shirt =
                new Product<>("Cotton Shirt", 1200,
                        new ClothingCategory());

        Product<GadgetCategory> laptop =
                new Product<>("Dell Laptop", 65000,
                        new GadgetCategory());

        MarketplaceUtility.applyDiscount(book, 10);
        MarketplaceUtility.applyDiscount(shirt, 20);
        MarketplaceUtility.applyDiscount(laptop, 15);

        List<Product<?>> catalog = new ArrayList<>();

        catalog.add(book);
        catalog.add(shirt);
        catalog.add(laptop);

        MarketplaceUtility.displayCatalog(catalog);
    }
}