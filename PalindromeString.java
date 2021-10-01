import java.util.*;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the string:");
        String str = input.nextLine();

        int n = str.length();
        char charArray[] = new char[n]; // Create char array as I don't know how to use char array in Java.

        for (int i = 0; i < n; i++)
            charArray[i] = str.charAt(i);


        // Loop to check if the string contains special characters.
        for (int i = 0; i < n; i++){
            if (Character.isAlphabetic(charArray[i]) || charArray[i] == ' ')
                continue;
            else{
                System.out.println("Invalid string");
                return;
            }
        }

        int i = 0, j = n - 1;
        boolean flag = true;
        
        while (i < j){
            if (charArray[i] != charArray[j]){
                System.out.println("The entered string is not a palindrome.");
                flag = !flag;
                break;
            }
            i++;
            j--;
        }
        if (flag)
            System.err.println("Entered string is a palindrome.");
    }
}
