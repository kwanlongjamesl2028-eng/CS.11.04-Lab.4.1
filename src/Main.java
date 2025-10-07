import java.util.Scanner;

public class Main {
    
    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false; // More closing parentheses than opening ones
            }
        }
        return count == 0; // Return true if all parentheses are matched
    }

    // 2. reverseInteger
    public static String reverseInteger(int n) {
        String str = Integer.toString(n);
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    // 3. encryptThis
    public static String encryptThis(String input) {
        String[] words = input.split(" ");
        StringBuilder encryptedMessage = new StringBuilder();

        for (String word : words) {
            encryptedMessage.append(encryptWord(word)).append(" ");
        }

        return encryptedMessage.toString().trim(); 
    }

    private static String encryptWord(String word) {
        if (word.length() == 0) return "";
        StringBuilder encrypted = new StringBuilder();
        encrypted.append((int) word.charAt(0)); 
        if (word.length() > 1) {
            encrypted.append(word.charAt(word.length() - 1)); 
            for (int i = 2; i < word.length() - 1; i++) {
                encrypted.append(word.charAt(i)); 
            }
            encrypted.append(word.charAt(1));
        }

        return encrypted.toString(); 
    }

    // 4. decipherThis
     public static String decipherThis(String input) {
        String[] words = input.split(" ");
        StringBuilder decryptedMessage = new StringBuilder();
        for (String word : words) {
            decryptedMessage.append(decipherWord(word)).append(" ");
        }
        return decryptedMessage.toString().trim();
     }

    // Helper method for decipherThis
    private static String decipherWord(String word) {
        if (word.length() == 0) return "";
        // Extract leading digits (ASCII code)
        int i = 0;
        while (i < word.length() && Character.isDigit(word.charAt(i))) {
            i++;
        }
        int ascii = Integer.parseInt(word.substring(0, i));
        char firstChar = (char) ascii;
        String rest = word.substring(i);

        if (rest.length() <= 1) {
            return firstChar + rest;
        } else {
            char[] chars = rest.toCharArray();
            char temp = chars[0];
            chars[0] = chars[chars.length - 1];
            chars[chars.length - 1] = temp;
            return firstChar + new String(chars);
        }
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(parenthesesCheck("(())")); 
        System.out.println(reverseInteger(1234)); 
        System.out.println(encryptThis("Hello good day")); 
        System.out.println(decipherThis("72olle 103doo 100ya"));
    }
}