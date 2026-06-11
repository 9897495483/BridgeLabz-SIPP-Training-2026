// A kingdom's tax system charges 5% for income <10K, 15% for 10K–
// 50K, 30% above 50K. Read a citizen's income, print tax bracket and
// amount. Extend: loop over an array of 10 citizens and tally total tax
// collected.
import java.util.*;
public class tax_calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[]arr=new double[10];
        for(int i=0;i<10;i++){
            arr[i]=sc.nextDouble();
        }
        for(int i=0;i<10;i++){
            if(arr[i]<10000){
                System.out.println("amount"+i+"tax"+(0.05*arr[i]));
            }
            else if(arr[i]>=10000 && arr[i]<50000){
                System.out.println("amount"+i+"tax"+(0.15*arr[i]));
            }
            else{
                System.out.println("amount"+i+"tax"+(0.3*arr[i]));
            }
    }
}
}
