/*A warehouse stores item quantities in an array. Find the max, min,
total stock, and detect duplicates. Extend: rotate the stock array by
k positions (simulate daily shift handover), and transpose a 2D shelf
grid.*/
import java.util.*;
public class scenario {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] stocks={45,20,60,20,90,15,60};
        int a=stocks.length;
        //max && min
        int max=stocks[0];
        int min=stocks[0];
        for(int i=1;i<a;i++){
            if(stocks[i]>max){
                max=stocks[i];  
            }
            if(stocks[i]<min){
                min=stocks[i];  
            }
        }
        System.out.println("Maximum stock: " + max);
        System.out.println("Minimum stock: " + min);
        //total stock
        int total=0;
        for(int i=0;i<a;i++){
            total+=stocks[i];       
    }   
        System.out.println("Total stock: " + total);
        //detect duplicates
        for(int i=0;i<a;i++){
            for(int j=i+1;j<a;j++){
                if(stocks[i]==stocks[j]){
                    System.out.println("Duplicate stock quantity found: " + stocks[i]);
                }
            }
        }
        //rotate array by k positions
            System.out.println("Enter the number of positions to rotate the stock array:");
            int k=sc.nextInt();
            k=k%a; 
            int[] rotated=new int[a];
            for(int i=0;i<a;i++){
            rotated[i]=(i+k<a) ? stocks[i+k] : stocks[i+k-a];   
            
            }
            System.out.println("Rotated array:");
            for(int i=0;i<a;i++){
                System.out.print(rotated[i] + " ");
            }
        //transpose a 2D shelf grid
            System.out.println("\nEnter the number of rows and columns for the shelf grid:");
            int rows=sc.nextInt();
            int cols=sc.nextInt();
            int[][] shelf=new int[rows][cols];
            System.out.println("Enter the stock quantities for the shelf grid:");
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    shelf[i][j]=sc.nextInt();
                }
            }
            int[][] transposed=new int[cols][rows];
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    transposed[j][i]=shelf[i][j];
                }
            }
            System.out.println("Transposed shelf grid:");
            for(int i=0;i<cols;i++){
                for(int j=0;j<rows;j++){
                    System.out.print(transposed[i][j] + " ");   
                }
                System.out.println();
            }
}
}
