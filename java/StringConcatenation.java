import java.util.*;

public class StringConcatenation {
    public static void helper(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        for(int i = 0; i < firstName.length(); i++){
            if (Character.isAlphabetic(firstName.charAt(i)) || firstName.charAt(i) == ' ')
                continue;
            else{
                System.out.println("Invalid name!");
                return;
            }
        }        

        for (int i = 0; i < lastName.length(); i++){
            if (Character.isAlphabetic(lastName.charAt(i)) || lastName.charAt(i) == ' ')
                continue;
            else{
                System.out.println("Invalid name!");
                return;
            }
        }
        System.out.println("Welcome " + firstName.toUpperCase() + " " + lastName.toUpperCase());
        input.close();

        return;
    }
    
    public static void main(String[] args) {
        helper();
    }
}
