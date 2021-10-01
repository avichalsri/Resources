import java.security.PublicKey;
import java.util.Scanner;

public class PrintUniqueCharacters {
    public static void helper(){
        // Display characters in the string that occurs only once.
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the string:");

        String str = input.nextLine();
        str = str.toLowerCase();
        input.close();

        // Create a hash map to store the characters in the string.

        int[] hashMap = new int[128];
        for (int i = 0; i < str.length(); i++) {
            hashMap[str.charAt(i)] += 1;
        }

        // Display the characters that occur only once.

        for(int i = 0; i < 128; i++){
            if (hashMap[i] == 1) {
                System.out.println((char)i);
            }
        }

    }
        
    public static void main(String[] args) {
        helper();
    }
}
