// 2. . Secret Message Validator 
// A security application receives a secret code.
// Write a program that:
// Accepts a string.
// Counts vowels, consonants, digits, and special characters.
// Determines whether the code is "Strong" or "Weak" based on:
// At least 2 digits
// At least 1 special character
// Minimum length of 8
// Displays a detailed report.
import java.util.Scanner;
public class secret_message_validator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the secret message: ");
        String message = scanner.nextLine();
        
        // Initialize counters
        int vowelCount = 0;
        int consonantCount = 0;
        int digitCount = 0;
        int specialCharacterCount = 0;
        
        // Iterate through each character in the message
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            
            // Check if the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowelCount++;
            }
            // Check if the character is a consonant
            else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                consonantCount++;
            }
            // Check if the character is a digit
            else if (ch >= '0' && ch <= '9') {
                digitCount++;
            }
            // Otherwise, it's a special character
            else {
                specialCharacterCount++;
            }
        }
        
        // Display counts
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);
        System.out.println("Digits: " + digitCount);
        System.out.println("Special Characters: " + specialCharacterCount);
        
        // Determine strength based on criteria
        boolean isStrong = true;
        
        if (digitCount < 2) {
            isStrong = false;
        }
        
        if (specialCharacterCount < 1) {
            isStrong = false;
        }
        
        if (message.length() < 8) {
            isStrong = false;
        }
        
        if (isStrong) {
            System.out.println("The secret message is Strong.");
        } else {
            System.out.println("The secret message is Weak.");
        }
        
        System.out.println("Detailed Report:");
        System.out.println("- Vowels: " + vowelCount);
        System.out.println("- Consonants: " + consonantCount);
        System.out.println("- Digits: " + digitCount);
        System.out.println("- Special Characters: " + specialCharacterCount);
        scanner.close();
    }
}
