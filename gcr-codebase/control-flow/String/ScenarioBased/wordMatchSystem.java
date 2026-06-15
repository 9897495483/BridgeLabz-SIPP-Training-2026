// 3. Word Match System
// A recruitment portal receives two skill keywords from a candidate.
// Write a program that:
// Accepts two strings.
// Checks whether they are anagrams.
// Displays both strings in uppercase.
// Shows the total length of each string.
// Prints a suitable message based on the result.

import java.util.*;
public class wordMatchSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   
        System.out.print("Enter the first skill keyword: ");
        String keyword1 = scanner.nextLine();
        System.out.print("Enter the second skill keyword: ");
        String keyword2 = scanner.nextLine();   
        // Check if the keywords are anagrams
        if (areAnagrams(keyword1, keyword2)) {
            System.out.println("The keywords are anagrams.");
        } else {
            System.out.println("The keywords are not anagrams.");
        }   
        // Display both strings in uppercase
        System.out.println("First keyword in uppercase: " + keyword1.toUpperCase());
        System.out.println("Second keyword in uppercase: " + keyword2.toUpperCase());   
        // Show the total length of each string 
        System.out.println("Length of first keyword: " + keyword1.length());
        System.out.println("Length of second keyword: " + keyword2.length());
        
        scanner.close();
    }   
    public static boolean areAnagrams(String str1, String str2) {
        // Remove spaces and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();   
        // Check if the sorted characters of both strings are the same
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return java.util.Arrays.equals(charArray1, charArray2);
    }
}