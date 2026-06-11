// Ravi just joined a coding guild. Store his name, age, rank, salary, and
// membership fee (float) using correct data types. Compute his
// annual bonus (12% of salary), cast it to int, and print a formatted
// welcome card.
import java.util.*;
public class bonus_calculator {
    String name;
    int age;
    int rank;
    int salary;
    float membership_fee;
    double bonus;
    void bonus(){
        bonus = 0.12*salary;
        System.out.println((int)bonus);
    }
    static void calling(){ 
        Scanner sc = new Scanner(System.in);
        bonus_calculator obj = new bonus_calculator();
        obj.name = sc.next(); obj.age = sc.nextInt(); 
        obj.rank = sc.nextInt(); 
        obj.salary = sc.nextInt();
        obj.membership_fee = sc.nextFloat();
        obj.bonus(); 
        sc.close();
    }
    public static void main(String[] args){
        bonus_calculator.calling();
    }
}