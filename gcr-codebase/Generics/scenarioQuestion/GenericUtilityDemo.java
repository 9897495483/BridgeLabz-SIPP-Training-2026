import java.util.*;

// Generic Pair Class
class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

// Generic Stack Class
class GenericStack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty!");
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public void display() {
        System.out.println("Stack: " + stack);
    }
}

// Generic Repository Class
class Repository<T> {
    private ArrayList<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
    }

    public void display() {
        System.out.println(data);
    }
}

// Utility Class
class GenericUtils {

    // Generic Method with Comparable Bound
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        T max = arr[0];

        for (T item : arr) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    // Wildcard Method
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}

// Sample Classes
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Main Class
public class GenericUtilityDemo {

    public static void main(String[] args) {

        // Pair
        Pair<String, Integer> pair = new Pair<>("Age", 21);
        System.out.println("Pair: " + pair);

        // Stack
        GenericStack<String> stack = new GenericStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("C++");

        stack.display();

        System.out.println("Popped: " + stack.pop());

        stack.display();

        // findMax()
        Integer[] numbers = {10, 45, 22, 99, 30};
        System.out.println("Maximum = " + GenericUtils.findMax(numbers));

        // Repository
        Repository<Student> studentRepo = new Repository<>();
        studentRepo.add(new Student("Raghav"));
        studentRepo.add(new Student("Rahul"));

        System.out.print("Students: ");
        studentRepo.display();

        Repository<Employee> employeeRepo = new Repository<>();
        employeeRepo.add(new Employee("Amit"));
        employeeRepo.add(new Employee("Neha"));

        System.out.print("Employees: ");
        employeeRepo.display();

        // Wildcard List<?>
        List<String> languages = Arrays.asList("Java", "Python", "C++");
        List<Integer> marks = Arrays.asList(85, 90, 95);

        System.out.print("Languages: ");
        GenericUtils.printList(languages);

        System.out.print("Marks: ");
        GenericUtils.printList(marks);
    }
}