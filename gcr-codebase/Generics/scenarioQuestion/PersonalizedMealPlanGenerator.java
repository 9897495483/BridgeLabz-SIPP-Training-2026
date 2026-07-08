import java.util.ArrayList;
import java.util.List;

// MealPlan Interface
interface MealPlan {
    String getMealName();
}

// Meal Types
class VegetarianMeal implements MealPlan {

    @Override
    public String getMealName() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {

    @Override
    public String getMealName() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {

    @Override
    public String getMealName() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {

    @Override
    public String getMealName() {
        return "High Protein Meal";
    }
}

// Generic Meal Class
class Meal<T extends MealPlan> {

    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }

    public void displayMeal() {
        System.out.println("Meal Plan : " + meal.getMealName());
    }
}

// Utility Class
class MealPlanGenerator {

    // Generic Method
    public static <T extends MealPlan> void generateMealPlan(T meal) {
        System.out.println("Generated Meal Plan : " + meal.getMealName());
    }

    // Wildcard Method
    public static void displayMeals(List<? extends MealPlan> meals) {

        System.out.println("\nAvailable Meal Plans:");

        for (MealPlan meal : meals) {
            System.out.println(meal.getMealName());
        }
    }
}

// Main Class
public class PersonalizedMealPlanGenerator {

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegetarian =
                new Meal<>(new VegetarianMeal());

        Meal<VeganMeal> vegan =
                new Meal<>(new VeganMeal());

        Meal<KetoMeal> keto =
                new Meal<>(new KetoMeal());

        Meal<HighProteinMeal> protein =
                new Meal<>(new HighProteinMeal());

        vegetarian.displayMeal();
        vegan.displayMeal();
        keto.displayMeal();
        protein.displayMeal();

        System.out.println();

        MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        MealPlanGenerator.generateMealPlan(new VeganMeal());
        MealPlanGenerator.generateMealPlan(new KetoMeal());
        MealPlanGenerator.generateMealPlan(new HighProteinMeal());

        List<MealPlan> mealList = new ArrayList<>();

        mealList.add(new VegetarianMeal());
        mealList.add(new VeganMeal());
        mealList.add(new KetoMeal());
        mealList.add(new HighProteinMeal());

        MealPlanGenerator.displayMeals(mealList);
    }
}