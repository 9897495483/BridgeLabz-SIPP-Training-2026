
// A spy agency encodes messages. Reverse a secret message, check if
// it is a palindrome, count vowels/consonants, and verify if two
// intercepts are anagrams. Extend: find the first non-repeating
// character in a surveillance log.
import java.util.*;
public class palindromeString {
   public static void main(String[] args) {
        String str="madan";
        String reversed="";
        //reverse
        for(int i=str.length()-1;i>=0;i--){
            reversed+=str.charAt(i);
        }
        // checking palindrome
        if(str.equals(reversed)){
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
        //count vowels and consonants
        int vowels=0;
        int consonants=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                vowels++; 
            }
            else if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
                consonants++; 
            }
   } 
   System.out.println("Vowels: " + vowels);
   System.out.println("Consonants: " + consonants);
   // check anagrams
   String str1="listen";
   String str2="silent";
   if(str1.length()!=str2.length()){
    System.out.println(str1 + " and " + str2 + " are not anagrams.");   
   }
    else{
     char[] arr1=str1.toCharArray();
     char[] arr2=str2.toCharArray();
     Arrays.sort(arr1);
     Arrays.sort(arr2);
     if(Arrays.equals(arr1, arr2)){
          System.out.println(str1 + " and " + str2 + " are anagrams.");
     }
     else{
          System.out.println(str1 + " and " + str2 + " are not anagrams.");
     }
    }
    // find first non-repeating character
    String log="swiss";
    char nonRepeating=' ';
    for(int i=0;i<log.length();i++){
        char ch=log.charAt(i);
        if(log.indexOf(ch)==log.lastIndexOf(ch)){
            nonRepeating=ch;
            break;
        }
    }
    if(nonRepeating!=' '){
        System.out.println("First non-repeating character: " + nonRepeating);
    }
    else{
        System.out.println("No non-repeating character found.");
    }
}
}
