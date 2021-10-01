import java.util.*;


public class SumOfMaxAndMin{
    public static void helper(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array:");
        int n = input.nextInt();

        if (n < 1){
            System.out.println("Invalid input");
            return;
        }
        int [] arr = new int[n];
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;


        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++){
            arr[i] = input.nextInt();
            maxi = Math.max(maxi, arr[i]);
            mini = Math.min(mini, arr[i]);
        }
        System.out.println("The sum of maximum and minimum values is: " + (maxi + mini));
        return ;
    }
    
    public static void main(String[] args) {
        helper();
    }
}
