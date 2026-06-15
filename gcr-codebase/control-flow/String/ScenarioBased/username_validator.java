// 1. Username Validator 
// A company wants to validate usernames entered by users.
// Write a program that:
// Accepts a username.
// Checks whether it contains any spaces.
// Counts the total number of characters.
// Converts the username to uppercase.
// Displays whether the username is a palindrome.

import java.util.Scanner;
public class username_validator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        
        // Check for spaces
        if (username.contains(" ")) {
            System.out.println("Username should not contain spaces.");
        } else {
            System.out.println("Username does not contain spaces.");
        }
        
        // Count total number of characters
        int characterCount = username.length();
        System.out.println("Total number of characters: " + characterCount);
        
        // Convert to uppercase
        String uppercaseUsername = username.toUpperCase();
        System.out.println("Username in uppercase: " + uppercaseUsername);
        
        // Check if it's a palindrome
        String reversed="";
        for(int i=0;i<username.length();i++){
            reversed=username.charAt(i)+reversed;
        }
        if(username.equals(reversed)){
            System.out.println("The username is a palindrome.");
        } else {
            System.out.println("The username is not a palindrome.");
        }
        scanner.close();
    }
}